package com.itech.ups.app.business.website.forum.application.infrastructure;

import com.itech.ups.app.forum.application.domain.Forum;
import com.itech.ups.app.forum.application.domain.ForumPosts;
import com.itech.ups.app.forum.application.domain.PostsReply;
import com.itech.ups.base.application.infrastructure.dataaccess.AbstractRepositoryParent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ForumRepository extends AbstractRepositoryParent {

    public Forum addForum(Forum forum) {
        forum.setId(generateIdentifier());
        sqlMapClientTemplate.insert("forum.insertForum", forum);
        return forum;
    }

    public void delForum(String id) {
        sqlMapClientTemplate.delete("forum.deleteForum", id);
    }

    public void editForumPosts(ForumPosts forumPosts) {
        sqlMapClientTemplate.update("forum.editForumPost", forumPosts);
    }

    public void editPostsReply(PostsReply postsReply) {
        sqlMapClientTemplate.update("forum.editPostsReply", postsReply);
    }

    public Forum findForum(String id) {
        Forum forum = (Forum) sqlMapClientTemplate.queryForObject("forum.findForum", id);
        return forum;
    }

    public int findForumPicturesTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("forum.findForumPicturesTotalCount", map);
        return totalCount;
    }

    public ForumPosts findForumPost(String id) {
        ForumPosts forumPosts = (ForumPosts) sqlMapClientTemplate.queryForObject("forum.findForumPost", id);
        return forumPosts;
    }

    public List<ForumPosts> findForumPosts(Map<String, Object> map) {
        List<ForumPosts> forumPostsList = sqlMapClientTemplate.queryForList("forum.findForumPosts", map);
        return forumPostsList;
    }

    public int findForumPostsTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("forum.findForumPostsTotalCount", map);
        return totalCount;
    }

    public List<Forum> findForums(Map<String, Object> map) {
        List<Forum> forumList = sqlMapClientTemplate.queryForList("forum.findForums", map);
        return forumList;
    }

    public List<Forum> findForumsSelect(Map<String, Object> map) {
        return sqlMapClientTemplate.queryForList("forum.findForumsSelect", map);
    }

    public int findForumsTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("forum.findForumsTotalCount", map);
        return totalCount;
    }

    public List<Map<String, String>> findPageForumPosts(Map<String, Object> map) {
        List<Map<String, String>> forumPostsList = sqlMapClientTemplate.queryForList("forum.findPageForumPosts", map);
        return forumPostsList;
    }

    public List<Map<String, String>> findPageForums(Map<String, Object> map) {
        List<Map<String, String>> forumList = sqlMapClientTemplate.queryForList("forum.findPageForums", map);
        return forumList;
    }

    public List<PostsReply> findPagePostsReplies(Map<String, Object> map) {
        List<PostsReply> postsReplyList = sqlMapClientTemplate.queryForList("forum.findPagePostsReplies", map);
        return postsReplyList;
    }

    public List<PostsReply> findPostsReplies(Map<String, Object> map) {
        List<PostsReply> replyList = sqlMapClientTemplate.queryForList("forum.findPostsReplies", map);
        return replyList;
    }

    public int findPostsRepliesTotalCount(Map<String, Object> map) {
        int totalCount = (Integer) sqlMapClientTemplate.queryForObject("forum.findPostsRepliesTotalCount", map);
        return totalCount;
    }

    public PostsReply findPostsReply(String id) {
        PostsReply postsReply = (PostsReply) sqlMapClientTemplate.queryForObject("forum.findPostsReply", id);
        return postsReply;
    }

    public void updateForum(Forum forum) {
        sqlMapClientTemplate.update("forum.editForum", forum);
    }

    public void updateForumPostsParentId(String oldId, String newId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oldForumId", oldId);
        map.put("newForumId", newId);
        sqlMapClientTemplate.update("forum.updatePostsParentId", map);
    }
}
