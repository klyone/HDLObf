source source_classpath.sh

rm -rf $5
ls $3 || touch $3
cd ../bin
java Obfuscate $*
