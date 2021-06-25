package com.espazo.wiki.req;

public class EbookQueryReq extends PageReq {
    private Long id;

    private String name;

    private long category1Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(long category1Id) {
        this.category1Id = category1Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}