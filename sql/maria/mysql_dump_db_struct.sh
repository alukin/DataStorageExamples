#!/bin/sh

DB_NAME=$1
DB_USER=sds
DB_PASSWORD=qwerty
DB_HOST=localhost
OUT_FILE=${DB_NAME}_struct.sql

if [ -z "${1}" ] ; then
    echo "Usage: $0 dtabase_name"
    exit 1
fi
echo "dunping \"${DB_NAME}\" database structure to file ${OUT_FILE}" 
mysqldump -d -h ${DB_HOST} -u ${DB_USER} -p${DB_PASSWORD} ${DB_NAME} > ${OUT_FILE}
echo "done."
