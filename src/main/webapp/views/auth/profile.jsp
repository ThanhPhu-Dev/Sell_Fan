<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<title>Profile</title>
<main class="main">
    <div class="content">
        <form method="post" enctype="multipart/form-data">
            <div class="form-profile bg-light">
                <div class="avatar" >
                    <div id="avatar">
                        <img src="${avatar}"
                             width="200px" height="200px">
                    </div>
                    <div class="input-avatar">
                        <input type="file" name="fileName" class="custom-file-input" id="avatarinput"
                               onchange="ImagesFileAsURL()">
                    </div>
                </div>
                <div class="form-info">
                    <div class="mb-3">
                        <label for="name" class="form-label">Họ Tên</label>
                        <input type="text" class="form-control" id="name" name="username" value="${name}" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Số Điện Thoại</label>
                        <input type="text" class="form-control" id="phone" name="phone" value="${phone}">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Địa Chỉ</label>
                        <input type="text" class="form-control" id="address" name="address" value="${address}">
                    </div>
                    <c:if test="${not empty message}">
                        <div class="alert alert-success alert-message" role="alert">
                                ${message}
                        </div>
                    </c:if>
                    <button type="submit" style="width: 100px" class="btn btn-primary">Lưu</button>
                </div>
            </div>
        </form>
    </div>
</main>
<script type="text/javascript">
    function ImagesFileAsURL() {
        var fileSelected = document.getElementById('avatarinput').files;
        if (fileSelected.length > 0) {
            var fileToLoad = fileSelected[0];
            var fileReader = new FileReader();
            fileReader.onload = function (fileLoaderEvent) {
                var srcData = fileLoaderEvent.target.result;
                var newImage = document.createElement('img');
                newImage.style.width = "200";
                newImage.style.height = "200";
                newImage.src = srcData;
                document.getElementById('avatar').innerHTML = newImage.outerHTML;
            }
            fileReader.readAsDataURL(fileToLoad);
        }
    }
</script>