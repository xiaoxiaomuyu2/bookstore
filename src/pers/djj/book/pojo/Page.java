package pers.djj.book.pojo;

import java.util.List;

public class Page<T> {
    public static final int DEFAULT_SIZE = 4;

    private Integer pageNumber;
    private Integer totalPageCount;
    private Integer pageSize = DEFAULT_SIZE;
    private Integer totalItemCount;
    private List<T> itemList;
    private String url;

    public Page() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        if (pageNumber < 1) {
            this.pageNumber = 1;
        } else if (totalPageCount < pageNumber) {
            this.pageNumber = totalPageCount;
        } else {
            this.pageNumber = pageNumber;
        }
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            this.pageSize = DEFAULT_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

    public Integer getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(Integer totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Page{");
        sb.append("pageNumber=").append(pageNumber);
        sb.append(", totalPageCount=").append(totalPageCount);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", totalItemCount=").append(totalItemCount);
        sb.append(", itemList=").append(itemList);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
