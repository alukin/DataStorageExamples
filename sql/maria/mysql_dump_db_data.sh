#!/bin/sh

DB_NAME=$1
DB_USER=sds
DB_PASSWORD=qwerty
DB_HOST=localhost
OUT_FILE=${DB_NAME}_data.sql

if [ -z "${1}" ] ; then
    echo "Usage: $0 dtabase_name"
    exit 1
fi
echo "dunping \"${DB_NAME}\" database data to file ${OUT_FILE}" 
mysqldump --no-create-db --no-create-info  -h ${DB_HOST} -u ${DB_USER} -p${DB_PASSWORD} ${DB_NAME} > ${OUT_FILE}
echo "done."
