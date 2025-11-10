#!/bin/bash
set -e

if [ $# -lt 1 ]; then
    echo "Usage: $0 <source_directory>"
    echo "Example: $0 AdventureCharacter"
    exit 1
fi

SRC_DIR="$1"
BUILD_DIR="$SRC_DIR/build"

javac "$SRC_DIR"/*.java -d "$BUILD_DIR"

java -cp "$BUILD_DIR" ExerciseRunner
