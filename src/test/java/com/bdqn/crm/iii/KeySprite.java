package com.bdqn.crm.iii;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @author 忍
 * @title: Test
 * @projectName crm-project
 * @description: TODO
 * @date 2019/10/2210:58
 */
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

    /**
     * 支持脚本文件的按键控制程序
     */public class KeySprite{
        public static void main(String[] args){
            String filename = "../test.t";
            try{
                //读取配置文件
                Vector v = readFile(filename);
                //执行文件
                parseVector(v);

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("配置文件错误");
            }catch(Exception e){
                System.out.println("其他错误");
            }
        }
        /**
         * 读取文件到Vector中
         * @param filepath 文件路径
         */
        public static Vector readFile(String filepath) throws IOException{
            Vector v = new Vector();

            //文件缓冲输入流
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filepath)));
            //读取数据
            String s = br.readLine();
            while(s != null){
                //添加到v
                v.add(s);
                //读取下一行
                s = br.readLine();
            }
            //关闭输入流
            br.close();
            //返回数据
            return v;
        }

        /**
         * 解析读到的Vector，并执行对应的操作
         * @param v Vector对象
         */
        public static void parseVector(Vector v){
            int size = v.size();

            try{
                //创建Robot对象
                Robot r = new Robot();

                for(int i = 0;i < size;i++){
                    String s = (String)v.get(i);
                    //分解
                    String[] data = s.split(" ");
                    //解析执行
                    if(data[0].equals("移动")){
                        //获得坐标
                        int x = Integer.parseInt(data[1]);
                        int y = Integer.parseInt(data[2]);
                        //移动
                        r.mouseMove(x,y);
                    }else if(data[0].equals("按键")){
                        //获得按键种类
                        char c = data[1].toLowerCase().charAt(0);
                        //按键
                        r.keyPress(c);
                        //释放
                        r.keyRelease(c);
                    }else if(data[0].equals("暂停")){
                        //获得暂停时间
                        int time = Integer.parseInt(data[1]);
                        //暂停
                        Thread.sleep(time);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
