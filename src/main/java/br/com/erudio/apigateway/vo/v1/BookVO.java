package br.com.erudio.apigateway.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author","launch_date", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final long serialVersionUID =1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long Key;
    private String author;
    private Date launch_date;
    private double price;
    private String title;

    public BookVO(){}

    public Long getKey() {
        return Key;
    }

    public void setKey(Long key) {
        Key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookVO bookVO = (BookVO) o;
        return Double.compare(bookVO.price, price) == 0 && Objects.equals(Key, bookVO.Key) && Objects.equals(author, bookVO.author) && Objects.equals(launch_date, bookVO.launch_date) && Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Key, author, launch_date, price, title);
    }
}
