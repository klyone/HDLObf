
.PHONY: all clean

all:
	cd src && $(MAKE) ${ARGS}

clean:
	cd src && $(MAKE) clean ${ARGS}
