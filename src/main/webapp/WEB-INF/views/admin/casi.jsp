
<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Phần noi dung -->
    <div class="container"> 
        <div class="row"> 
         <h1 class="text-center">Quản lý Ca sĩ</h1> 
         <div class="col-md-10 col-md-offset-1"> 
          <div class="panel panel-default panel-table"> 
           <div class="panel-heading"> 
            <div class="row"> 
             <div class="col col-xs-6"> 
              <h3 class="panel-title">Danh sách khách hàng</h3> 
             </div> 
             <div class="col col-xs-6 text-right"> 
              <button type="button" class="btn btn-sm btn-primary btn-create">Thêm mới</button> 
             </div> 
            </div> 
           </div> 
           <div class="panel-body"> 
            <table class="table table-striped table-bordered table-list"> 
             <thead> 
              <tr> 
               
               <th class="hidden-xs">ID</th> 
               <th>Tên ca sĩ</th> 
               <th>Mô tả</th>
                <th>Hình ảnh</th>
               <th><em class="fa fa-cog"></em>
               </th> 
              </tr> 
             </thead> 
             <tbody>
              <tr> 
              
              <td class="hidden-xs">1</td> 
              <td>Khởi My</td> 
              <td>Nữ ca sĩ</td>
               <th>IMG</th>
              <td align="center"  >
                  
                  <a class="btn btn-default">
                  <em class="fa fa-pencil">                     
                  </em>
                </a>
                    <a class="btn btn-danger">
                    <em class="fa fa-trash"></em>
                    </a>
              </td> 
             </tr> 
            
            </tbody></table> 
           </div> 
           <div class="panel-footer"> 
            <div class="row"> 
             <div class="col col-xs-4">Trang 1 của 5 </div> 
             <div class="col col-xs-8"> 
              <ul class="pagination hidden-xs pull-right"> 
               <li><a href="http://hocwebgiare.com/#">1</a>
               </li> 
               <li><a href="http://hocwebgiare.com/#">2</a>
               </li> 
               <li><a href="http://hocwebgiare.com/#">3</a>
               </li> 
               <li><a href="http://hocwebgiare.com/#">4</a>
               </li> 
               <li><a href="http://hocwebgiare.com/#">5</a>
               </li> 
              </ul> 
              <ul class="pagination visible-xs pull-right"> 
               <li><a href="http://hocwebgiare.com/#">«</a>
               </li> 
               <li><a href="http://hocwebgiare.com/#">»</a>
               </li> 
              </ul> 
             </div> 
            </div> 
           </div> 
          </div> 
         </div> 
        </div>
       </div>