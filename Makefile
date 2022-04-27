all:
	rm -r out/
	javac -cp . -sourcepath src -d out/ src/*.java
	cp -R assets/ out/assets

run:
	javac -cp . -sourcepath src -d out/ src/*.java
	rm -r out/
	javac -cp . -sourcepath src -d out/ src/*.java
	cp -R assets/ out/assets
	java -cp out/ Main
