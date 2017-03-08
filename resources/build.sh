rm -Rf out
mkdir out
touch resources/files.txt
find . -iname *.java > resources/files.txt
javac -d out @resources/files.txt
rm resources/files.txt
jar cfm Blackjack.jar resources/Manifest.txt -C out .
