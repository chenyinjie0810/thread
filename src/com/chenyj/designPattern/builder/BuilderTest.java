package com.chenyj.designPattern.builder;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/2/17 15:18
 * 陈银杰专属测试
 */
public class BuilderTest {
    public static void main(String[] args) {
        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director director=new Director(defaultConcreteProductBuilder);
        Product product = director.makeProduct("鸡腿堡", "薯条", "可口可乐");
        System.out.println(product.toString());
    }
}

class Director{
    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String hamburger, String frenchFries, String cola){
        builder.buildHamburger(hamburger);
        builder.buildFrenchFries(frenchFries);
        builder.buildCola(cola);
        Product product = builder.build();
        return product;
    }

}

interface ProductBuilder{
    void buildHamburger(String hamburger);
    void buildFrenchFries(String frenchFries);
    void buildCola(String cola);
    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder{
    private String hamburger;
    private String frenchFries;
    private String cola;
    @Override
    public void buildHamburger(String hamburger) {
        this.hamburger=hamburger;
    }

    @Override
    public void buildFrenchFries(String frenchFries) {
        this.frenchFries=frenchFries;
    }

    @Override
    public void buildCola(String cola) {
        this.cola=cola;
    }

    @Override
    public Product build() {
        return new Product(this.hamburger,this.frenchFries,this.cola);
    }
}


class Product{
    private String hamburger;
    private String frenchFries;
    private String cola;

    public String getHamburger() {
        return hamburger;
    }

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public String getFrenchFries() {
        return frenchFries;
    }

    public void setFrenchFries(String frenchFries) {
        this.frenchFries = frenchFries;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Product{" +
                "hamburger='" + hamburger + '\'' +
                ", frenchFries='" + frenchFries + '\'' +
                ", cola='" + cola + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(String hamburger, String frenchFries, String cola) {
        this.hamburger = hamburger;
        this.frenchFries = frenchFries;
        this.cola = cola;
    }
}
