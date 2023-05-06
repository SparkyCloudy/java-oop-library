#!/bin/bash

# Output directory for compiled class files
out_dir=target

# Compile each .java file using Maven
mvn package

# Run the Main file
gnome-terminal -- java -jar $out_dir/*.jar