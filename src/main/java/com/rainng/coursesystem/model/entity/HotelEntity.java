package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("ht_specification")
@Data
public class HotelEntity {
	public static final String ID = "hotel_id";
    public static final String NAME = "hotel_name";
    public static final String MANAGERID="hotel_manager_id";
	public static final String TEL="hotel_tel";
	public static final String LONGITUDE="hotel_longitude";
	public static final String LATITUDE="hotel_latitude";
	public static final String DESC="hotel_describe";
	public static final String ROOMNUM="hotel_room_num";
	public static final String RANK="hotel_rank";
	public static final String MONTHSALES="hotel_monthly_sales";
	public static final String IMG="hotel_img";
	public static final String CITY="ht_city_name";
	public static final String ISOPEN="hotel_isopen";
	public static final String SALES="hotel_sales";
	public static final String AVAILABLE="hotel_available";
	public static final String MINPRICE="hotel_min_price";

    @TableId(value = ID, type = IdType.AUTO)
    private Integer hotelId;

    @NotBlank(message = "酒店名")
    @TableField(NAME)
    private String name;

    @TableField(MANAGERID)
	private Integer managerId;
    @Length(min=11,max=11,message="售后电话必须为11位数")
	@TableField(TEL)
	private String tel;	//电话
	@TableField(LONGITUDE)
	private Integer longitude=50;
	@TableField(LATITUDE)
	private Integer latitude=50;
	@TableField(ROOMNUM)
	private Integer roomnum=0;
	@TableField(RANK)
	private Double rank=0.0;
	@TableField(MONTHSALES)
	private Integer msales=0;
	@TableField(SALES)
	private Integer sales=0;
	@TableField(DESC)
	private String desc;
	@TableField(AVAILABLE)
	private Integer available=0;
	@TableField(IMG)
	private String img;
	@TableField(CITY)
	private String city;
	@TableField(ISOPEN)
	private Integer isopen=0;
	@TableField(MINPRICE)
	private Integer minprice;


	public Integer getManagerId() {
		return managerId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public String getDesc() {
		return desc;
	}

	public String getImg() {
		return img;
	}

	public Double getRank() {
		return rank;
	}

	public Integer getAvailable() {
		return available;
	}

	public Integer getIsopen() {
		return isopen;
	}

	public Integer getMinprice() {
		return minprice;
	}

	public Integer getMsales() {
		return msales;
	}

	public Integer getRoomnum() {
		return roomnum;
	}

	public Integer getSales() {
		return sales;
	}

	public String getCity() {
		return city;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}

	public void setMsales(Integer msales) {
		this.msales = msales;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
}

