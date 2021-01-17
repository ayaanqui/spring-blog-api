package com.github.ayaanqui.springblogapi.serializers;

import java.sql.Timestamp;

import com.github.ayaanqui.springblogapi.models.Post;
import com.github.slugify.Slugify;

public class PostSerailizer {
    public static class PostInfo {
        public Integer id;
        public String title, image, content, description;
        public Timestamp published;

        // Custom fields
        public String slug;

        public PostInfo(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.image = post.getImage();
            this.content = post.getContent();
            this.description = post.getDescription();
            this.published = post.getPublished();

            this.slug = new Slugify().slugify(this.title);
        }
    }
}
