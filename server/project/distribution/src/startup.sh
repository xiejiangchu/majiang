#!/bin/sh


nohup java   -server  -verbose:gc   -cp ./client majiang.client.ClientMain > log/clientMain.log 2>&1 &
nohup java   -server  -verbose:gc   -cp ./manager majiang.client.ManagerMain > log/managerMain.log 2>&1 &
nohup java   -server  -verbose:gc   -cp ./boss game.boss.BossMain > log/bossMain.log 2>&1 &
nohup java   -server  -verbose:gc   -cp ./scene game.scene.SceneMain > log/sceneMain.log 2>&1 &
nohup java   -server  -verbose:gc   -cp ./gateway game.gateway.GatewayMain > log/gatewayMain.log 2>&1 &

