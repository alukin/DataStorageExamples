createuser app -d
echo "alter user app with encrypted password 'qwerty';" | psql template1
#enter password qwerty
createdb -U app --owner app --password -E UTF8 --locale=en_US.UTF-8 app2
