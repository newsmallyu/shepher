#!/bin/sh

echo "PROJECT_BASE_DIR :"$PROJECT_BASE_DIR
#cd $APP_ROOT_DIR
cd $PROJECT_BASE_DIR

REMOTE_CONF="REMOTE_CONF_"
envs=`env|grep $REMOTE_CONF`
while read line
do
    arr[i++]=$line
done <<EOF
$envs
EOF
for arg in "${arr[@]}"
do
    key=${arg%%=*}
    value=${arg#*=}
    echo "key :"$key
    index=`expr match "$key" "$REMOTE_CONF"`
    if [ $index -ne 0 ]; then
        fileName=${key:$index}
        if wget -O $fileName"_temp" $value; then
            echo "get config with git $fileName"
            mv $fileName"_temp" $fileName
        else
            echo "config $fileName download fail! address: $value"
            if [ ! -f $fileName ]; then
                echo "not find config by address:"$value
                exit 2
            else
                echo "run with already exist "$fileName
            fi
        fi
    fi
done

exec java -jar shepher-web-1.0.jar

