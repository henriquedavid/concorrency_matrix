#! /bin/bash
now=$(date +"%T")
echo "Current time 2 S: $now"
java -jar SequentialxConcorrent.jar 2 S
now=$(date +"%T")
echo "Current time 2 C: $now"
java -jar SequentialxConcorrent.jar 2 C
now=$(date +"%T")
echo "Current time 4 S: $now"
java -jar SequentialxConcorrent.jar 4 S
now=$(date +"%T")
echo "Current time 4 C: $now"
java -jar SequentialxConcorrent.jar 4 C
now=$(date +"%T")
echo "Current time 8 S: $now"
java -jar SequentialxConcorrent.jar 8 S
now=$(date +"%T")
echo "Current time 8 C: $now"
java -jar SequentialxConcorrent.jar 8 C
now=$(date +"%T")
echo "Current time 16 S: $now"
java -jar SequentialxConcorrent.jar 16 S
now=$(date +"%T")
echo "Current time 16 C: $now"
java -jar SequentialxConcorrent.jar 16 C
now=$(date +"%T")
echo "Current time 32 S: $now"
java -jar SequentialxConcorrent.jar 32 S
now=$(date +"%T")
echo "Current time 32 C: $now"
java -jar SequentialxConcorrent.jar 32 C
now=$(date +"%T")
echo "Current time 64 S: $now"
java -jar SequentialxConcorrent.jar 64 S
now=$(date +"%T")
echo "Current time 64 C: $now"
java -jar SequentialxConcorrent.jar 64 C
now=$(date +"%T")
echo "Current time 128 S: $now"
java -jar SequentialxConcorrent.jar 128 S
now=$(date +"%T")
echo "Current time 128 C: $now"
java -jar SequentialxConcorrent.jar 128 C
now=$(date +"%T")
echo "Current time 256 S: $now"
java -jar SequentialxConcorrent.jar 256 S
now=$(date +"%T")
echo "Current time 256 C: $now"
java -jar SequentialxConcorrent.jar 256 C
now=$(date +"%T")
echo "Current time 512 S: $now"
java -jar SequentialxConcorrent.jar 512 S
now=$(date +"%T")
echo "Current time 512 C: $now"
java -jar SequentialxConcorrent.jar 512 C
now=$(date +"%T")
echo "Current time 1024 S: $now"
java -jar SequentialxConcorrent.jar 1024 S
now=$(date +"%T")
echo "Current time 1024 C: $now"
java -jar SequentialxConcorrent.jar 1024 C
now=$(date +"%T")
echo "Current time 2048 S: $now"
java -jar SequentialxConcorrent.jar 2048 S
now=$(date +"%T")
echo "Current time 2048 C: $now"
java -jar SequentialxConcorrent.jar 2048 C
now=$(date +"%T")
echo "End : $now"
