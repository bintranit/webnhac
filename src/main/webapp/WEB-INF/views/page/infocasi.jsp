<%@ include file="/common/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
        <div class="bradcumbContent">
            <h2>Thông tin ca sĩ</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100">
        <div class="container">
            <div class="row">


                <div class="col-12 col-lg-6">
                    <div class="testimonials-area mb-100 bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
                        <div class="section-heading white text-left mb-50">
	                            <h2>${tencasi.tencasi}</h2>
                        </div>
                        <!-- Testimonial Slide -->
                        <div class="testimonials-slide owl-carousel">
                            <!-- Single Slide -->
                            <div class="single-slide">
                                <p>${tencasi.motacasi}</p>
                                <div class="testimonial-info d-flex align-items-center">
                                    <div class="testimonial-thumb">
                                        <img src="${tencasi.hinhanhcasi}" alt="">
                                    </div>
                                    
                                    
                                   
                                </div>
                            </div>
                           
                        </div>
                    </div>
                </div>
               
                    


            </div>
            


        </div>
    </section>
    <!-- Bai Hat -->
       <!-- ##### Album Catagory Area Start ##### -->
       <section class="album-catagory section-padding-100-0">

        <div class="container">


            <div class="row oneMusic-albums">

			<c:forEach var = "item" items="${dulieutrang}">
				<!-- Single Album -->
				<div
					class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item t c p">
					<div class="single-album">
						<img src="${item.linkhinhanh}" alt="">
						<div class="album-info">
							<a href="http://localhost:8088/webnhac/baihat?idbaihat=${item.id}">
								<h5>${item.tennhac}</h5>
							</a>
							<p>Second Song</p>
						</div>
					</div>
				</div>
			</c:forEach>





		</div>
        </div>

        <!-- Phân trang -->
        <div class="row">
		<div class="col-12">
			<div
				class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">

				<c:if test="${trang > 1 }">
					<a href="http://localhost:8080/webnhac/infocasi?page=${trang-1}">Trang trước</a>
				</c:if>
				<c:forEach var="i" step="1" begin="1" end="${tongsotrang }">
					<c:choose>
						<c:when test="${trang == i }">
							<a href="http://localhost:8088/webnhac/infocasi?page=${i }" class="active">${i }</a>
						</c:when>
						<c:otherwise>
							<a href="http://localhost:8088/webnhac/infocasi?page=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${trang < tongsotrang }">
					<a href="http://localhost:8088/webnhac/infocasi?page=${trang+1}">Trang sau</a>
				</c:if>

			</div>
		</div>
	</div>
    </section>
    <!-- ##### Album Catagory Area End ##### -->