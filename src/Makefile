SRC_DIR=./
LEX=$(SRC_DIR)/Verilog2001.g4
SRC=$(SRC_DIR)/Obfuscate.java
BIN_DIR=../bin
BIN=$(BIN_DIR)/Obfuscate.class

.PHONY: compile clean run
compile:
	mkdir $(BIN_DIR)
	./compile.sh

clean:
	rm -rf $(BIN_DIR)
	rm -rf log/*.dat

bin/Obfuscate.class: $(SRC) $(LEX)
	$(MAKE) compile
