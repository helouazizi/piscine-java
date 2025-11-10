#!/bin/bash

# Stop on errors
set -e

# Check if an argument was passed
if [ -z "$1" ]; then
  echo "Usage: $0 <path/to/ClassName.java>"
  exit 1
fi

# Extract directory and filename
TARGET_PATH="$1"
DIR_PATH=$(dirname "$TARGET_PATH")
CLASS_NAME=$(basename "$TARGET_PATH" .java)

# Create directory if it doesn't exist
mkdir -p "$DIR_PATH"

# Create the Java class file (if not exists)
if [ ! -f "$TARGET_PATH" ]; then
  cat > "$TARGET_PATH" <<EOF
public class $CLASS_NAME {
    // TODO: Implement $CLASS_NAME class
}
EOF
  echo "✅ Created: $TARGET_PATH"
else
  echo "⚠️  File already exists: $TARGET_PATH"
fi

# Create the ExerciseRunner.java file
RUNNER_FILE="$DIR_PATH/ExerciseRunner.java"
if [ ! -f "$RUNNER_FILE" ]; then
  cat > "$RUNNER_FILE" <<EOF
public class ExerciseRunner {
    public static void main(String[] args) {
        System.out.println("Running exercise for $CLASS_NAME...");
        // You can instantiate and test your $CLASS_NAME class here
        // Example:
        // $CLASS_NAME obj = new $CLASS_NAME();
    }
}
EOF
  echo "✅ Created: $RUNNER_FILE"
else
  echo "⚠️  Runner already exists: $RUNNER_FILE"
fi
