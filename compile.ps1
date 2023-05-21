# Output directory for compiled class files
$out_dir="target"

# Compile each .java file using Maven
mvn clean package -D maven.plugin.validation=default

# Run the Main file
#gnome-terminal -- java -jar $out_dir/*.jar
$jar=Get-ChildItem -Path $out_dir/*.jar
java -jar $jar