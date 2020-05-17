package com.itech.ups.app.business.website.forum.application.service;

import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.app.forum.application.domain.PostsReply;

import java.util.List;
import java.util.Map;


public interface ForumService {

    void delForum(String id);

    void editForum(Forum forum);

    void editForumPosts(ForumPosts forumPosts);

    void editPostsReply(PostsReply postsReply);

    Forum findForum(String id);

    ForumPosts findForumPost(String id);

    List<ForumPosts> findForumPosts(Map<String, Object> map);

    int findForumPostsTotalCount(Map<String, Object> map);

    List<Forum> findForums(Map<String, Object> map);

    List<Forum> findForumsSelect(Map<String, Object> map);

    int findForumsTotalCount(Map<String, Object> map);

    List<Map<String, String>> findPageForumPosts(Map<String, Object> map, int rowStart, int rowEnd);

    List<Map<String, String>> findPageForums(Map<String, Object> map, int rowStart, int rowEnd);

    List<PostsReply> findPagePostsReplies(Map<String, Object> map, int rowStart, int rowEnd);

    List<PostsReply> findPostsReplies(Map<String, Object> map);

    int findPostsRepliesTotalCount(Map<String, Object> map);

    PostsReply findPostsReply(String id);

    Forum saveForum(Forum forum);

    void updateFormPostsParentId(String id, String id2);
}
