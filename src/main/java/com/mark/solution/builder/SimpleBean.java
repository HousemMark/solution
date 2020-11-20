package com.mark.solution.builder;

public class SimpleBean {
    private String name;
    private Integer age;
    private String address;
    private String gender;

    private SimpleBean(Builder builder) {
        name = builder.name;
        age = builder.age;
        address = builder.address;
        gender = builder.gender;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "name:" + name + "\n" + "age:" + age + "\n" + "gender:" + gender + "\n" + "address:" + address;
    }

    // 内部类建造者实现
    public static class Builder {
        private String name;
        private Integer age;
        private String address;
        private String gender;

        public SimpleBean build() {
            return new SimpleBean(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
    }
}
