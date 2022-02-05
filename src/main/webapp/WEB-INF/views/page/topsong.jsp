<%@ include file="/common/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <!-- ##### Latest Albums Area Start ##### -->
    <section class="latest-albums-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading style-2">
                        <p>Nghe gì hôm nay ?</p>
                        <h2>Top ca khúc nổi bật</h2>
                       
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <div class="albums-slideshow owl-carousel">

					<c:forEach var="item1" items="${dulieubaihattop}">
						<div class="single-album">
                            <img src="${item1.linkhinhanh}" alt="">
                            <div class="album-info">
                                <a href="http://localhost:8088/webnhac/baihat?idbaihat=${item1.id}	">
                                    <h5>${item1.tennhac}</h5>
                                </a>
                                <div class="album-price">
								<p>${item1.luotnghe} lượt nghe</p>
							</div>
                            </div>
                        </div>
					</c:forEach>
					
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Latest Albums Area End ##### -->


    <section class="oneMusic-buy-now-area has-fluid bg-gray section-padding-100">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading style-2">
                        
                        <h2>Ca khúc ngẫu nhiên</h2>
                    </div>
                </div>
            </div>

		<div class="row">

			<c:forEach var="item1" items="${dulieutrang}">
				<div class="col-12 col-sm-6 col-md-4 col-lg-2">
					<div class="single-album-area wow fadeInUp" data-wow-delay="100ms">
						<div class="album-thumb">
							<img src="${item1.linkhinhanh}" alt="">
							
							<div class="album-price">
								<p>${item1.luotnghe} lượt nghe</p>
							</div>
							
						
							<!-- Play Icon -->
                            <div class="play-icon">
                                <a href="http://localhost:8088/webnhac/baihat?idbaihat=${item1.id}" "><span class="icon-play-button"></span></a>
                            </div>
						</div>
						<div class="album-info">
							<a href="#">
								<h5>${item1.tencasi}</h5>
							</a>
							<p>${item1.tennhac}</p>
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
					<a href="http://localhost:8088/webnhac/trangchu/?page=${trang-1}">Trang trước</a>
				</c:if>
				<c:forEach var="i" step="1" begin="1" end="${tongsotrang }">
					<c:choose>
						<c:when test="${trang == i }">
							<a href="http://localhost:8088/webnhac/trangchu/?page=${i }" class="active">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="http://localhost:8088/webnhac/trangchu/?page=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${trang < tongsotrang }">
					<a href="http://localhost:8088/webnhac/trangchu/?page=${trang+1}">Trang sau</a>
				</c:if>

			</div>
		</div>
	</div>
</section>
    <!-- ##### Buy Now Area End ##### -->