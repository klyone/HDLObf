BASE_DIR=`pwd`
LIB_DIR="${BASE_DIR}/../lib"
ANTLR_DIR="${LIB_DIR}/antlr-2.7.4.jar"
export CLASSPATH=".:${ANTLR_DIR}:$CLASSPATH"
