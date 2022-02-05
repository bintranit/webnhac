<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="<c:url value="/resources/baihat.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="breadcumb-area bg-img bg-overlay"
	style="background-image: url(https://dictionary.cambridge.org/vi/images/thumb/black_noun_002_03536.jpg?version=5.0.203); background-repeat: no-repeat;");">

</div>

<!-- ##### Featured Artist Area Start ##### -->
<section
	class="featured-artist-area section-padding-100 bg-img bg-overlay bg-fixed"
	style="background-image: url(${chitietbaihat.linkhinhanh});background-repeat: no-repeat;");">

	<div class="container">
		<div class="row align-items-end">
			<div class="col-12 col-md-5 col-lg-4">
				<div class="featured-artist-thumb">
					<img src="${chitietbaihat.hinhanhcasi}" alt="">
				</div>
			</div>
			<div class="col-12 col-md-7 col-lg-8">
				<div class="featured-artist-content">
					<!-- Section Heading -->
					<div class="section-heading white text-left mb-30">
						<p>Ca khúc</p>
						<h2>${chitietbaihat.tennhac}</h2>
						<p style="font-size: 30px">${chitietbaihat.tencasi}</p>

					</div>

					<div class="song-play-area">

						<audio preload="auto" controls>
							<source src="${chitietbaihat.linknhac}" />
							<source src="audio/dummy-audio.mp3">
						</audio>

					</div>
					<p style="font-size: 30px">Lời bài hát:</p>
					<p>${chitietbaihat.loibaihat}</p>


					<p style="font-size: 30px">Tag : ${tentheloai.tentheloai}</p>
					<a href="${chitietbaihat.linknhac}">
						<p style="font-size: 20px">
							Tải xuống
						</p>
					</a>
				</div>

			</div>
		</div>
		<div class="song-item">
			<p style="font-size: 20px">Bài hát cùng ca sĩ</p>
			<div class="row">
				<div class="col-xl-5 col-lg-12 col-md-5">
					<div class="song-info-box">
						<c:forEach var="item" items="${baihatcungcasi}">
							<div class="album-info">
							 <a
									href="http://localhost:8088/webnhac/baihat?idbaihat=${item.id}	">
									<p style="font-size: 20px"> ${item.tentheloai} / <b>${item.tennhac} </b></p>
								</a>
								
								
								
							</div>

						</c:forEach>
					</div>
				</div>

			</div>


		</div>
	</div>


</section>
<!-- ##### Featured Artist Area End ##### -->





<!-- ##### Contact Area Start ##### -->
<section
	class="contact-area section-padding-100 bg-img bg-overlay bg-fixed has-bg-img"
	style="background-image: url(img/bg-img/bg-2.jpg);">
	>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading white"></div>
			</div>
		</div>

		<!-- Main Body -->
		<section>
			<div class="container">
				<div class="row">
					<div class="col-sm-5 col-md-6 col-12 pb-4">
					<h1>Comments</h1>

						<c:forEach var="item6" items="${baihatcmt}">										
							     <div class="comment mt-4 text-justify float-left">
							      <img src="${item6.hinhanh_user}" alt="" class="rounded-circle" width="40" height="40">
                                <h4>Tài khoản ${item6.tentk}</h4>
                                 <span>- Đã bình luận     .</span> <br>
                                <p>${item6.textComment}</p>

                            </div>							
						</c:forEach>
					</div>
					<div
						class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4">
						<form action="http://localhost:8088/webnhac/xulycomment/${id_baihat}" method="get" >
							<div class="form-group">
								<h4>Để lại bình luận</h4>
								
									<div class="form-group">
                                    <h4>Leave a comment</h4> <label for="message">Message</label> <textarea name="comment" id="comment"  cols="30" rows="5" class="form-control" style="background-color: black;"></textarea>
                                </div>
							</div>
							<div class="form-group">
								<input type="submit" id="post" class="btn" value="Binh luận" />
								
								
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<div class="row">
			<div class="col-12">
				<!-- Contact Form Area -->
				<div class="contact-form-area"></div>
			</div>
		</div>
	</div>
</section>