if [[ $(lsof -t -i:8181) ]]; then
   kill -9 $(lsof -t -i:8181 )
fi

mvn clean &&
mvn package &&
nohup java -jar target*.jar &
