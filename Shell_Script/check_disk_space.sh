#!/bin/bash

alert_on=60

disk_usage=$(df -h / | awk 'NR==2 {gsub(/[^0-9]/, "", $6); print $6}')

alert_file="/c/Users/Abdullah ASM/OneDrive/Desktop/ITI/CASE_STUDIES/Shell_Script/alert_file.txt"

timestamp=$(date +"%Y-%m-%d %H:%M:%S")

if [ "$disk_usage" -gt "$alert_on" ]; then

    echo "Disk space exceeded $alert_on%, it is $disk_usage% at $timestamp" >> "$alert_file"
else

    echo "Disk space did not exceed $alert_on%, it is $disk_usage% at $timestamp" >> "$alert_file"
fi