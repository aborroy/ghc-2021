
Google Hashcode 2021
=============================

Out of Floc solution for [Google Hashcode 2021](https://hashcode.withgoogle.com/).

Hash Code Judge System for problem statement and submissions available in https://hashcodejudge.withgoogle.com/

Compiling
---------

```bash
$ mvn clean package
```

Running
-------

```bash
$ java -jar target/hashcode-2021-1.0.0.jar \
  --fileIn=in/a_example.in \
  --fileOut=a_example.out \
  --strategy=0
```
Available strategies:

* 0: SIMPLE
* 1: COMPLEX

Generating ZIP Source file
--------------------------

```bash
$ ./zip.sh

$ ls *.zip
src.zip
```
