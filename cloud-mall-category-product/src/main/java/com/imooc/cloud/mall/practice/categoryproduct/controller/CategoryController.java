package com.imooc.cloud.mall.practice.categoryproduct.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.categoryproduct.model.pojo.Category;
import com.imooc.cloud.mall.practice.categoryproduct.model.request.AddCategoryReq;
import com.imooc.cloud.mall.practice.categoryproduct.model.request.UpdateCategoryReq;
import com.imooc.cloud.mall.practice.categoryproduct.model.vo.CategoryVO;
import com.imooc.cloud.mall.practice.categoryproduct.service.CategoryService;
import com.imooc.cloud.mall.practice.common.common.ApiRestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * 描述：     目录Controller
 */
@Controller
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    /**
     * 后台添加目录
     */
    @ApiOperation("后台添加目录")
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session,
            @Valid @RequestBody AddCategoryReq addCategoryReq) {

        categoryService.add(addCategoryReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台更新目录")
    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(@Valid @RequestBody UpdateCategoryReq updateCategoryReq,
            HttpSession session) {
        Category category = new Category();
        BeanUtils.copyProperties(updateCategoryReq, category);
        categoryService.update(category);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台删除目录")
    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @GetMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping("category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOS);
    }
}
