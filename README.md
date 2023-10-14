Create executable jar file
```
javac *.java
jar cfe JsonParser.jar Main *.class
```

Create a json-parser binary file in a 'path' location
```
cd /path/to/binary/directory
sudo touch json-parser
sudo chmod +x json-parser
sudo vi json-parser
```

Add shebang line at the beginning of json-parser script
```
#!/bin/bash
java -jar /path/to/JsonParser.jar "$@"
```

Example Usage:
```
json-parser test.txt
cat test.txt | json-parser
curl https://www.exapmle.txt | json-parser
```
