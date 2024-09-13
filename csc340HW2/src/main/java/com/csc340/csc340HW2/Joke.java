package com.csc340.csc340HW2;
//icon_url" : "https://api.chucknorris.io/img/avatar/chuck-norris.png",
//        "id" : "3Z5D16wESESpsRuoZ1HgrQ",
//        "url" : "",
//        "value" : "Chuck Norris was asked if he's ever done any bareback riding? Chuck replied that every woman he's ever been with has given him a bare back ride."
//        }
public class Joke {
    public String id;
    public String url;
    public String value;

    public Joke(String id, String url, String value) {
        this.id = id;
        this.url = url;
        this.value = value;
    }

//    public String getId() {return id;}
//    public void setId(String id){this.id = id;}
//
//    public String getUrl(){return url;}
//    public void setUrl(String url){this.url = url;}
//
//    public String getValue(){return value;}
//    public void setValue(String value){this.value = value;}
//}
public String getId() {
    return id;
}

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}