<%@ include file="/common/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
        <div class="bradcumbContent">
          
            <h2>Danh sách ${tentheloai.tentheloai}</h2>

        </div>	
        
    </section>
    <!-- ##### Buy Now Area Start ##### -->
    <section class="oneMusic-buy-now-area has-fluid bg-gray section-padding-100">


            <div class="row">
            
            <c:forEach var="item" items="${dulieutrang}">
            <!-- Single Album Area -->
                <div class="col-12 col-sm-6 col-md-4 col-lg-2">
                    <div class="single-album-area wow fadeInUp" data-wow-delay="100ms">
                        <div class="album-thumb">
                            <img src="${item.linkhinhanh}" alt="">
                   
                            <!-- Play Icon -->
                            <div class="play-icon">
                                <a href="http://localhost:8088/webnhac/baihat?idbaihat=${item.id}" "><span class="icon-play-button"></span></a>
                            </div>
                        </div>
                        <div class="album-info">
                            <a href="#">
                                <h5>${item.tennhac}</h5>
                            </a>
                            <p>${item.tencasi}</p>
                        </div>
                    </div>
                </div>
            
            </c:forEach>
                
            </div>
            <div class="row">
		<div class="col-12">
			<div
				class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">

				<c:if test="${trang > 1}">
					<a href="http://localhost:8088/webnhac/theloai?idtheloai=${idtheloai}&&page=${trang-1}">Trang trước</a>
				</c:if>
				<c:forEach var="i" step="1" begin="1" end="${tongsotrang}">
					<c:choose>
						<c:when test="${trang == i}">
							<a href="http://localhost:8088/webnhac/theloai?idtheloai=${idtheloai}&&page=${i}" class="active">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="http://localhost:8088/webnhac/theloai?idtheloai=${idtheloai}&&page=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${trang < tongsotrang}">
					<a href="http://localhost:8088/webnhac/theloai?idtheloai=${idtheloai}&&page=${trang+1}">Trang sau</a>
				</c:if>

			</div>
		</div>
	</div>

            
        
    </section>
    <!-- ##### Buy Now Area End ##### -->