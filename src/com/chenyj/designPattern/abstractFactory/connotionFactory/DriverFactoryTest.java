package com.chenyj.designPattern.abstractFactory.connotionFactory;

/**
 * @Author chenyj
 * @Description 抽象工厂模式
 * @Date create by 2020/2/14 15:22
 * 陈银杰专属测试
 */
public class DriverFactoryTest {
    public static void main(String[] args) {
        IDriverFactory driverFactory=new OracleDriverFactory();
        IConnection connection = driverFactory.getConnection();
        connection.connect();
        IComnand comnand = driverFactory.getComnand();
        comnand.comnand();
    }
}

/**
 * 创建连接
 */
interface IConnection{
    void connect();
}

/**
 * 执行操作
 */
interface IComnand{
    void comnand();
}

interface IDriverFactory{
    IConnection getConnection();
    IComnand getComnand();
}

class MysqlConnetion implements IConnection{

    @Override
    public void connect() {
        System.out.println("连接mysql");
    }
}
class MysqlComnand implements IComnand{

    @Override
    public void comnand() {
        System.out.println("执行mysql操作");
    }
}
class MysqlDriverFactory implements IDriverFactory{
    @Override
    public IConnection getConnection() {
        return new MysqlConnetion();
    }

    @Override
    public IComnand getComnand() {
        return new MysqlComnand();
    }
}

class OracleConnection implements IConnection{
    @Override
    public void connect() {
        System.out.println("连接oracle");
    }
}
class OracleCommand implements IComnand{

    @Override
    public void comnand() {
        System.out.println("执行oracle操作");
    }
}
class OracleDriverFactory implements IDriverFactory{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public IComnand getComnand() {
        return new OracleCommand();
    }
}