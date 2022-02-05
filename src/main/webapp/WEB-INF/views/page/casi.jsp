<%@ include file="/common/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
        <div class="bradcumbContent">
          
            <h2>Danh sách nghệ sĩ</h2>
            
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Album Catagory Area Start ##### -->
    <section class="album-catagory section-padding-100-0">

        
        <div class="container">


            <div class="row oneMusic-albums">

                <!-- Single Album -->
                <c:forEach var = "item" items="${dulieutrang}">
                 <div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
                    <div class="single-album">
                        <img src="${item.hinhanh }" alt="">
                        <div class="album-info">
                            <a href="#">
                                <a href="http://localhost:8088/webnhac/infocasi?idcasi=${item.id}">${item.tencasi}</a>
                            </a>
                            <p>Second Song</p>
                        </div>
                    </div>
                </div>
                 
                </c:forEach>










		</div>
        </div>

        <div class="row">
		<div class="col-12">
			<div
				class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">

				<c:if test="${trang > 1 }">
					<a href="http://localhost:8088/webnhac/casi?page=${trang-1}">Trang trước</a>
				</c:if>
				<c:forEach var="i" step="1" begin="1" end="${tongsotrang }">
					<c:choose>
						<c:when test="${trang == i }">
							<a href="http://localhost:8088/webnhac/casi?page=${i }" class="active">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="http://localhost:8088/webnhac/casi?page=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${trang < tongsotrang }">
					<a href="http://localhost:8088/webnhac/casi?page=${trang+1}">Trang sau</a>
				</c:if>

			</div>
		</div>
	</div>
    </section>