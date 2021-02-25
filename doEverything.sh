STRATEGY=$1

if [[ "#$STRATEGY" == "#" ]]
then
    echo "Usage: doEverything.sh [strategyId]"
    exit 1
fi

rm out/src.zip
./zip.sh
cp ./src.zip out/src.zip

for x in a b c d e f
do
    rm out/$x.out
    java -jar target/hashcode-2021-1.0.0.jar --fileIn=$x.txt --fileOut=$x.out --strategy=$STRATEGY
done
