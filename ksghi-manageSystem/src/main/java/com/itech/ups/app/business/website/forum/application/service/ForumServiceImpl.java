package com.itech.ups.app.business.website.forum.application.service;

import com.itech.ups.app.business.website.forum.application.infrastructure.ForumRepository;
import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.app.forum.application.domain.PostsReply;
import com.itech.ups.base.application.service.AbstractServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("forumService")
public class ForumServiceImpl extends AbstractServiceParent implements ForumService {

    @Autowired
    public ForumRepository repository;

    public void delForum(String id) {
        repository.delForum(id);
    }

    public void editForum(Forum forum) {
        repository.updateForum(forum);
    }

    @Override
    public void editForumPosts(ForumPosts forumPosts) {
        repository.editForumPosts(forumPosts);
    }

    @Override
    public void editPostsReply(PostsReply postsReply) {
        repository.editPostsReply(postsReply);
    }

    public Forum findForum(String id) {
        Forum forum = repository.findForum(id);
        return forum;
    }

    public ForumPosts findForumPost(String id) {
        ForumPosts forumPosts = repository.findForumPost(id);
        return forumPosts;
    }

    public List<ForumPosts> findForumPosts(Map<String, Object> map) {
        List<ForumPosts> postList = repository.findForumPosts(map);
        return postList;
    }

    public int findForumPostsTotalCount(Map<String, Object> map) {
        return repository.findForumPostsTotalCount(map);
    }

    public List<Forum> findForums(Map<String, Object> map) {
        List<Forum> forumList = repository.findForums(map);
        return forumList;
    }

    @Override
    public List<Forum> findForumsSelect(Map<String, Object> map) {
        return repository.findForumsSelect(map);
    }

    public int findForumsTotalCount(Map<String, Object> map) {
        return repository.findForumsTotalCount(map);
    }

    public List<Map<String, String>> findPageForumPosts(Map<String, Object> map, int startNum, int endNum) {
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        List<Map<String, String>> forumPostsList = repository.findPageForumPosts(map);
        return forumPostsList;
    }

    public List<Map<String, String>> findPageForums(Map<String, Object> map, int startNum, int endNum) {
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        List<Map<String, String>> forumList = repository.findPageForums(map);
        return forumList;
    }

    @Override
    public List<PostsReply> findPagePostsReplies(Map<String, Object> map, int rowStart, int rowEnd) {
        map.put("startNum", rowStart);
        map.put("endNum", rowEnd);
        List<PostsReply> replyList = repository.findPagePostsReplies(map);
        return replyList;
    }

    @Override
    public List<PostsReply> findPostsReplies(Map<String, Object> map) {
        List<PostsReply> replyList = repository.findPostsReplies(map);
        return replyList;
    }

    @Override
    public int findPostsRepliesTotalCount(Map<String, Object> map) {
        return repository.findPostsRepliesTotalCount(map);
    }

    @Override
    public PostsReply findPostsReply(String id) {
        PostsReply postsReply = repository.findPostsReply(id);
        return postsReply;
    }

    public Forum saveForum(Forum forum) {
        forum = repository.addForum(forum);
        return forum;
    }

    public void updateFormPostsParentId(String oldId, String newId) {
        repository.updateForumPostsParentId(oldId, newId);
    }
}
