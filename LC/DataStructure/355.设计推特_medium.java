/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {

    //静态的全局时间戳，用来记录tweet的顺序
    private static int timestamp = 0;
    //需要一个映射，把userId和user关联起来
    private HashMap<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /**
     * 发布tweet
     * 
     * @param {int} userId
     * @param {int} tweetId
     * @return {*}
     */
    public void postTweet(int userId, int tweetId) {
        checkUserExist(userId);
        userMap.get(userId).post(tweetId);
    }
    
    /**
     * 实现合并k个有序链表的算法需要用到优先级队列。
     * 
     * @param {int} userId
     * @return {*}
     */
    public List<Integer> getNewsFeed(int userId) {
        //存放最终结果
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;

        //用户的关注列表
        Set<Integer> users = userMap.get(userId).followed;
        //创建一个大小为关注用户数的最大优先级队列
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a,b)->(b.time-a.time));

        //把所有的链表头结点放入优先级队列
        for(int id : users){
            Tweet twt = userMap.get(id).head;
            if(twt == null)continue;
            pq.add(twt);
        }

        //循环取最大值
        while(!pq.isEmpty()){
            if(res.size() == 10)break;
            Tweet twt = pq.poll();
            res.add(twt.id);
            //如果下一个Tweet不为空，插入
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        
        return res;
    }
    
    /**
     * follower 关注 followee
     * 
     * @param {int} followerId
     * @param {int} followeeId
     * @return {*}
     */
    public void follow(int followerId, int followeeId) {
        checkUserExist(followerId, followeeId);
        userMap.get(followerId).follow(followeeId);
    }
    
    /**
     * follower 取关 followee
     * 
     * @param {int} followerId
     * @param {int} followeeId
     * @return {*}
     */
    public void unfollow(int followerId, int followeeId) {
        checkUserExist(followerId, followeeId);
        userMap.get(followerId).unfollow(followeeId);
    }

    /**
     * 检查userId对应的用户是否存在
     * 
     * @param {Integer...} userId
     * @return {*}
     */
    private void checkUserExist(Integer... userId){
        for(int i=0; i<userId.length; i++){
            if(!userMap.containsKey(userId[i]))
                userMap.put(userId[i], new User(userId[i]));
        }
    }


    /*************** 首先设计推文和用户类 ***************/

    class Tweet{

        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    class User{

        int id;
        //用HashSet来表示用户的关注列表，需要实现不能重复以及快速查找
        public HashSet<Integer> followed;
        //用一个链表来表示用户的推文，链表的顺序表示用户推文的发布时间
        public Tweet head;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            this.head = null;
            follow(id);//由于检索推文时包括自己的推文，所以要先关注一下自己
        }
        
        //关注一个用户
        public void follow(int userId){
            followed.add(userId);
        }
        
        //取消关注用户
        public void unfollow(int userId){
            //不可以取关自己
            if(userId != this.id)
            followed.remove(userId);
        }
        
        //发布一条推文
        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            //把新建的推文插入链表头，越靠前，time值越大
            tweet.next = head;
            head = tweet;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

