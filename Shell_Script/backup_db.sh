#!/bin/bash

# Oracle Database Connection Details
DB_USER=admin
DB_PASSWORD=root
DB_SID=XE

# Backup Directory
BACKUP_DIR="C:/oraclexe/app/oracle/product/11.2.0/server/backup_directory"

# Admin Schema to be backed up
ADMIN_SCHEMA="ADMIN@XE"

# Date Format for Backup File
DATE_FORMAT=$(date +"%Y%m%d_%H%M%S")

# Export File Name (only the file name, not the full path)
EXPORT_FILE="${ADMIN_SCHEMA}_backup_${DATE_FORMAT}.dmp"

# Timestamp for logging
TIMESTAMP=$(date +"%Y-%m-%d %H:%M:%S")


# Oracle Data Pump Export Command
expdp ${DB_USER}/${DB_PASSWORD}@${DB_SID} DIRECTORY=DATA_PUMP_DIR DUMPFILE=${EXPORT_FILE} SCHEMAS=${ADMIN_SCHEMA}

# Check if the export was successful
if [ $? -eq 0 ]; then
    echo "${TIMESTAMP} Database backup successful. File: ${EXPORT_FILE}"
else
    echo "${TIMESTAMP} Error: Database backup failed."
fi