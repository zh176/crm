package com.bdqn.crm.iii;

import java.awt.*;
import java.awt.event.InputEvent;

public class Main {

    public static void main(String[] args) throws AWTException {
        // 创建 Robot 实例
        Robot robot = new Robot();

        // 执行完一个事件后再执行下一个
        robot.setAutoWaitForIdle(true);
        System.out.println(5555);
        // 移动鼠标到指定屏幕坐标
        robot.mouseMove(0, 0);

        // 按下鼠标左键
//        robot.mousePress(InputEvent.BUTTON1_MASK);
//        robot.mousePress(InputEvent.BUTTON3_MASK );llllll
//
//        // 延时100毫秒
//        robot.delay(100);
//        // 释放鼠标左键（按下后必须要释放, 一次点击操作包含了按下和释放）
//        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

}