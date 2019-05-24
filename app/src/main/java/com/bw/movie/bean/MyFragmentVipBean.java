package com.bw.movie.bean;

import java.util.List;

public class MyFragmentVipBean {

    /**
     * result : {"cinemasList":[{"address":"朝阳区湖景东路11号新奥购物中心B1(东A口)","commentTotal":0,"distance":0,"followCinema":0,"id":5,"logo":"http://mobile.bwstudent.com/images/movie/logo/CGVxx.jpg","name":"CGV星星影城"},{"address":"北京市育知东路30号华联商厦4层","commentTotal":0,"distance":0,"followCinema":0,"id":20,"logo":"http://mobile.bwstudent.com/images/movie/logo/wmyc.jpg","name":"北京沃美影城（回龙观店）"},{"address":"海淀区中关村广场购物中心津乐汇三层（鼎好一期西侧）","commentTotal":0,"distance":0,"followCinema":0,"id":12,"logo":"http://mobile.bwstudent.com/images/movie/logo/mjhlyc.jpg","name":"美嘉欢乐影城中关村店"}],"headPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","integral":0,"movieList":[{"fare":0,"id":17,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ftfb3/ftfb(3)1.jpg","name":"反贪风暴3","releaseTime":1537545600000,"summary":"ICAC (廉政公署) 陆志廉（古天乐 饰），JFIU (联合财富情报组) 刘保强（张智霖 饰）分别侦查贪污及洗黑钱案，但苦无线索，这时廉政公署L组 (内部纪律调查组) 程德明（郑嘉颖 饰）收到举报，指陆志廉收贿1200万，陆无法辩解实时停职。刘发现陆被诬陷，并跟一直调查的洗黑钱案有着千丝万缕关系，同时怀疑银行主任游子新（栢天男 饰）协助罪恶集团洗黑钱；陆冒险搜集罪证却遭禁锢，命悬一线......."},{"fare":0,"id":16,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","name":"碟中谍6：全面瓦解","releaseTime":1569081600000,"summary":"有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。"},{"fare":0,"id":19,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","name":"江湖儿女","releaseTime":1537545600000,"summary":"故事起始于2001年的山西大同，模特巧巧（赵涛 饰）与出租车公司老板斌哥（廖凡 饰）是一对恋人，斌哥每天在外面呼朋唤友，巧巧却希望两人能够尽快步入婚姻的殿堂。然而一次斌哥在街头遭到竞争对手的袭击，巧巧为了保护斌哥在街头开枪，被判刑五年。巧巧出狱以后，开始寻找斌哥以便重新开始，然而事情却发生了意想不到的变化。"}],"nickName":"sc","phone":"15225080444","userSignStatus":1}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * cinemasList : [{"address":"朝阳区湖景东路11号新奥购物中心B1(东A口)","commentTotal":0,"distance":0,"followCinema":0,"id":5,"logo":"http://mobile.bwstudent.com/images/movie/logo/CGVxx.jpg","name":"CGV星星影城"},{"address":"北京市育知东路30号华联商厦4层","commentTotal":0,"distance":0,"followCinema":0,"id":20,"logo":"http://mobile.bwstudent.com/images/movie/logo/wmyc.jpg","name":"北京沃美影城（回龙观店）"},{"address":"海淀区中关村广场购物中心津乐汇三层（鼎好一期西侧）","commentTotal":0,"distance":0,"followCinema":0,"id":12,"logo":"http://mobile.bwstudent.com/images/movie/logo/mjhlyc.jpg","name":"美嘉欢乐影城中关村店"}]
         * headPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * integral : 0
         * movieList : [{"fare":0,"id":17,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ftfb3/ftfb(3)1.jpg","name":"反贪风暴3","releaseTime":1537545600000,"summary":"ICAC (廉政公署) 陆志廉（古天乐 饰），JFIU (联合财富情报组) 刘保强（张智霖 饰）分别侦查贪污及洗黑钱案，但苦无线索，这时廉政公署L组 (内部纪律调查组) 程德明（郑嘉颖 饰）收到举报，指陆志廉收贿1200万，陆无法辩解实时停职。刘发现陆被诬陷，并跟一直调查的洗黑钱案有着千丝万缕关系，同时怀疑银行主任游子新（栢天男 饰）协助罪恶集团洗黑钱；陆冒险搜集罪证却遭禁锢，命悬一线......."},{"fare":0,"id":16,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","name":"碟中谍6：全面瓦解","releaseTime":1569081600000,"summary":"有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。"},{"fare":0,"id":19,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","name":"江湖儿女","releaseTime":1537545600000,"summary":"故事起始于2001年的山西大同，模特巧巧（赵涛 饰）与出租车公司老板斌哥（廖凡 饰）是一对恋人，斌哥每天在外面呼朋唤友，巧巧却希望两人能够尽快步入婚姻的殿堂。然而一次斌哥在街头遭到竞争对手的袭击，巧巧为了保护斌哥在街头开枪，被判刑五年。巧巧出狱以后，开始寻找斌哥以便重新开始，然而事情却发生了意想不到的变化。"}]
         * nickName : sc
         * phone : 15225080444
         * userSignStatus : 1
         */

        private String headPic;
        private int integral;
        private String nickName;
        private String phone;
        private int userSignStatus;
        private List<CinemasListBean> cinemasList;
        private List<MovieListBean> movieList;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getUserSignStatus() {
            return userSignStatus;
        }

        public void setUserSignStatus(int userSignStatus) {
            this.userSignStatus = userSignStatus;
        }

        public List<CinemasListBean> getCinemasList() {
            return cinemasList;
        }

        public void setCinemasList(List<CinemasListBean> cinemasList) {
            this.cinemasList = cinemasList;
        }

        public List<MovieListBean> getMovieList() {
            return movieList;
        }

        public void setMovieList(List<MovieListBean> movieList) {
            this.movieList = movieList;
        }

        public static class CinemasListBean {
            /**
             * address : 朝阳区湖景东路11号新奥购物中心B1(东A口)
             * commentTotal : 0
             * distance : 0
             * followCinema : 0
             * id : 5
             * logo : http://mobile.bwstudent.com/images/movie/logo/CGVxx.jpg
             * name : CGV星星影城
             */

            private String address;
            private int commentTotal;
            private int distance;
            private int followCinema;
            private int id;
            private String logo;
            private String name;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getCommentTotal() {
                return commentTotal;
            }

            public void setCommentTotal(int commentTotal) {
                this.commentTotal = commentTotal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollowCinema() {
                return followCinema;
            }

            public void setFollowCinema(int followCinema) {
                this.followCinema = followCinema;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class MovieListBean {
            /**
             * fare : 0
             * id : 17
             * imageUrl : http://mobile.bwstudent.com/images/movie/stills/ftfb3/ftfb(3)1.jpg
             * name : 反贪风暴3
             * releaseTime : 1537545600000
             * summary : ICAC (廉政公署) 陆志廉（古天乐 饰），JFIU (联合财富情报组) 刘保强（张智霖 饰）分别侦查贪污及洗黑钱案，但苦无线索，这时廉政公署L组 (内部纪律调查组) 程德明（郑嘉颖 饰）收到举报，指陆志廉收贿1200万，陆无法辩解实时停职。刘发现陆被诬陷，并跟一直调查的洗黑钱案有着千丝万缕关系，同时怀疑银行主任游子新（栢天男 饰）协助罪恶集团洗黑钱；陆冒险搜集罪证却遭禁锢，命悬一线.......
             */

            private int fare;
            private int id;
            private String imageUrl;
            private String name;
            private long releaseTime;
            private String summary;

            public int getFare() {
                return fare;
            }

            public void setFare(int fare) {
                this.fare = fare;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }
        }
    }
}
