package org.aws.model;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@JsonIgnoreProperties(ignoreUnknown = true)
@DynamoDBTable(tableName = "WeatherData")
public class WeatherData {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAttribute
    private String id;
    @DynamoDBAttribute
    @DynamoDBTypeConvertedJson
    private String base;
    @DynamoDBAttribute
    @DynamoDBTypeConvertedJson
    private Clouds clouds;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private int cod;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private Coord coord;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private long dt;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private Main main;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private String name;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private rain rain;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private Sys sys;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private int timezone;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private int visibility;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private Weather[] weather;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute
    private Wind wind;

     

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public rain getRain() {
		return rain;
	}

	public void setRain(rain rain) {
		this.rain = rain;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    public static class Clouds {
        private int all;

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class Coord {
        private double lat;
        private double lon;
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		public double getLon() {
			return lon;
		}
		public void setLon(double lon) {
			this.lon = lon;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class Main {
        private double feels_like;
        private int grnd_level;
        private int humidity;
        private int pressure;
        private int sea_level;
        private double temp;
        private double temp_max;
        private double temp_min;
		public double getFeels_like() {
			return feels_like;
		}
		public void setFeels_like(double feels_like) {
			this.feels_like = feels_like;
		}
		public int getGrnd_level() {
			return grnd_level;
		}
		public void setGrnd_level(int grnd_level) {
			this.grnd_level = grnd_level;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		public int getPressure() {
			return pressure;
		}
		public void setPressure(int pressure) {
			this.pressure = pressure;
		}
		public int getSea_level() {
			return sea_level;
		}
		public void setSea_level(int sea_level) {
			this.sea_level = sea_level;
		}
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public double getTemp_max() {
			return temp_max;
		}
		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
		public double getTemp_min() {
			return temp_min;
		}
		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class rain {
        private double h1;

        
        public double getH1() {
            return h1;
        }

        public void setH1(double h1) {
            this.h1 = h1;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class Sys {
        private String country;
        private int id;
        private long sunrise;
        private long sunset;
        private int type;
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getSunrise() {
			return sunrise;
		}
		public void setSunrise(long sunrise) {
			this.sunrise = sunrise;
		}
		public long getSunset() {
			return sunset;
		}
		public void setSunset(long sunset) {
			this.sunset = sunset;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class Weather {
        private String description;
        private String icon;
        private int id;
        private String main;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMain() {
			return main;
		}
		public void setMain(String main) {
			this.main = main;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
   
    
    
    static class Wind {
        private int deg;
        private double speed;
        private double gust;
		public int getDeg() {
			return deg;
		}
		public void setDeg(int deg) {
			this.deg = deg;
		}
		public double getSpeed() {
			return speed;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public double getGust() {
			return gust;
		}
		public void setGust(double gust) {
			this.gust = gust;
		}

        
    }
}
