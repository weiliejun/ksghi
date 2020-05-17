<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/video/videojs/js/video.js"></script>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/assets/ui/core/plugins/video/videojs/css/video-js.css"></link>
<!-- Unless using the CDN hosted version, update the URL to the Flash SWF -->
<script type="text/javascript">
    videojs.options.flash.swf = "${pageContext.request.contextPath}/assets/ui/core/plugins/video/videojs/js/video-js.swf";
</script>
