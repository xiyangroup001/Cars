package com.xiyan.model.monitor;

/**
 * @antuor binwang
 * @date 2018/2/2  13:43
 */
public class TmonitorConstants {
    /***
     * 通用监控后缀
     */
    public static final String SUCCESS = "_Success";
    public static final String FAIL = "_Fail";
    public static final String INVOKE = "_Invoke";
    public static final String EXECUTE = "_Execute";

    /**
     * API监控后缀，加在ApiTemplate后面
     */
    public static final String BIZ_ERROR = "_BizError";
    public static final String INTERNAL_ERROR = "_InternalError";

    /**
     * Biz监控后缀，加在BizTemplate后面
     */
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "_IllegalArgumentException";
    public static final String DATA_EXPIRED_EXCEPTION = "_DataExpiredException";
    public static final String BIZ_EXCEPTION = "_BizException";
    public static final String RUNTIME_EXCEPTION = "_RuntimeException";
    public static final String SYSTEM_EXCEPTION = "_SystemException";
    public static final String EXCEPTION = "_Exception";

    // 域账号后缀
    public static final String TUJIA = "@tujia";
    // 房屋费用插入
    public static final String HOUSE_CHARGE_INSERT = "house_charge_insert";
    // 房屋费用更新
    public static final String HOUSE_CHARGE_UPDATE = "house_charge_update";
    // 房屋费用更新早餐
    public static final String HOUSE_CHARGE_UPDATE_BREAKFASTITEM = "house_charge_update_breakfastitem";
    // 房屋费用更新额外费用
    public static final String HOUSE_CHARGE_UPDATE_EXTRACHARGEITEM = "house_charge_update_extrachargeitem";
    // 房屋费用更新加人
    public static final String HOUSE_CHARGE_UPDATE_ADDPERSONITEM = "house_charge_update_addpersonitem";
    // 房屋费用更新押金设置
    public static final String HOUSE_CHARGE_UPDATE_DEPOSITITEM = "house_charge_update_deposititem";
    // 更新房屋币种
    public static final String HOUSE_CHARGE_CURRENCY = "house_charge_currency";
    // 房屋查询列表插入
    public static final String HOUSE_SEARCH_INSERT = "house_search_insert";
    // 使用门店ID查询房屋数量
    public static final String HOUSE_QUERY_COUNT_BY_HOTEL_ID = "house_query_count_by_hotel_id";
    // 使用门店ID查询上架房屋数量
    public static final String HOUSE_QUERY_ACTIVE_COUNT_BY_HOTEL_ID = "house_query_active_count_by_hotel_id";

    /**
     * -------------房屋-------------
     */
    // 房屋插入
    public static final String HOUSE_INFO_INSERT = "house_info_insert";
    // 同步房屋系统房屋数据
    public static final String SYNC_MERCHANT_HOUSE_INFO = "sync_merchant_house_info";
    // 房屋更新
    public static final String HOUSE_INFO_UPDATE = "house_info_update";
    // 查询房屋
    public static final String HOUSE_INFO_QUERY = "house_info_query";
    // 根据房屋id查询房屋
    public static final String HOUSE_INFO_QUERY_BY_HOUSE_ID = "house_info_query_by_house_id";
    // 根据房屋Number查询
    public static final String HOUSE_INFO_QUERY_BY_HOUSE_NUMBER = "house_info_query_by_house_number";
    // 保存房屋（新增/更新/删除）
    public static final String SAVE_HOUSE = "save_house";
    // 删除房屋
    public static final String HOUSE_INFO_DELETE = "house_info_delete";
    // 房屋按照id List查询
    public static final String HOUSE_SEARCH_QUERY_BY_HOUSE_ID_LIST = "house_search_query_by_house_id_list";
    // 按照房屋guid查询房屋
    public static final String HOUSE_SEARCH_QUERY_BY_HOUSE_GUID = "house_search_query_by_house_guid";
    // 根据门店id查询房屋
    public static final String HOUSE_INFO_QUERY_BY_HOTEL_ID = "house_info_query_by_hotel_id";
    // 根据门店Id和房屋上架状态查询
    public static final String HOUSE_INFO_QUERY_BY_HOTEL_ID_ACTIVE = "house_info_query_by_hotel_id_active";

    /**
     * -------------Dubbo 房屋-------------
     */
    // 房屋按照门店Id查询
    public static final String DUBBO_QUERY_HOUSE_INFO_BY_HOTEL_ID = "dubbo_query_house_info_by_hotel_id";
    // 房屋按照门店id和上下架状态查询
    public static final String DUBBO_QUERY_HOUSE_INFO_BY_HOTEL_ID_ACTIVE = "dubbo_query_house_info_by_hotel_id_active";
    // 查询房屋详情
    public static final String DUBBO_QUERY_HOUSE_DETAIL_BY_HOTEL_ID_ACTIVE = "dubbo_query_house_detail_by_hotel_id_active";

    //按照门店Id查询所有所属房屋Id列表
    public static final String DUBBO_QUERY_HOUSE_ID_LIST_BY_HOTEL_ID = "dubbo_query_house_id_list_by_hotel_id";

    //按照门店Id查询所有所属房屋搜索信息列表
    public static final String DUBBO_QUERY_HOUSE_SEARCH_LIST_BY_HOTEL_ID = "dubbo_query_house_search_list_by_hotel_id";

    //查询房屋信息 更加房屋ID
    public static final String DUBBO_QUERY_HOUSE_INFO_BY_HOUSE_ID_ACTIVE = "dubbo_query_house_info_by_house_id_active";

    // 查询房屋信息 根据房屋Guid
    public static final String DUBBO_QUERY_HOUSE_INFO_BY_HOUSE_GUID_ACTIVE = "dubbo_query_house_info_by_house_guid_active";

    // 房屋更新货币
    public static final String DUBBO_HOUSE_CURRENCY_UPDATE = "dubbo_house_currency_update";
    // 根据城市Id查找房屋
    public static final String DUBBO_QUERY_HOUSE_ID_BY_CITY = "dubbo_query_house_id_by_city";
    // 根据房屋ids获取所有房屋詳情
    public static final String DUBBO_QUERY_HOUSE_DETAIL_BY_HOUSEID = "dubbo_query_house_detail_by_house_ids";
    // 查找房屋根据房屋Guid
    public static final String DUBBO_QUERY_HOUSE_INFO_BY_HOUSEGUID = "dubbo_query_house_info_by_houseguid";
    // 根据guid查找房屋Id
    public static final String DUBBO_QUERY_HOUSE_ID_BY_HOUSEGUID = "dubbo_query_house_id_by_houseguid";
    // 查找HouseId根据门店Id
    public static final String DUBBO_QUERY_HOUSE_ID_BY_HOTEL_ID = "dubbo_query_house_id_by_hotel_id";
    // 查找房屋图片根据房屋Id
    public static final String DUBBO_QUERY_HOUSE_PICTURE_BY_HOUSE_ID = "dubbo_query_house_picture_by_house_id";
    // 根据房屋Id查询房屋
    public static final String DUBBO_QUERY_HOUSE_BY_HOUSE_ID = "dubbo_query_house_by_house_id";
    // 根据房屋Ids查询房屋
    public static final String DUBBO_QUERY_HOUSE_LIST_BY_HOUSE_IDS = "dubbo_query_house_list_by_house_ids";
    // 根据房屋Id查询房屋
    public static final String DUBBO_QUERY_HOUSE_CONTENT_BY_HOUSE_ID = "dubbo_query_house_content_by_house_id";

    public static final String DUBBO_QUERY_HOUSE_DETAIL_BY_HOUSE_ID = "dubbo_query_house_detail_by_house_id";

    public static final String DUBBO_HOUSE_QUERY_AUDIT_STATUS_BY_GUID = "dubbo_house_query_audit_status_by_guid";

    public static final String DUBBO_HOUSE_SERVICE_ADD_EXCEPTION = "dubbo_house_service_add_exception";
    // C端模型
    public static final String DUBBO_HOUSE_CONTENT_QUERY_BY_HOUSEID = "dubbo_house_content_query_by_houseid";

    /**
     * -------------房屋列表-------------
     */
    // 房屋列表查询
    public static final String HOUSE_SEARCH_QUERY = "house_search_query";
    // 房屋列表更新
    public static final String HOUSE_SEARCH_UPDATE = "house_search_update";
    // 房屋列表删除
    public static final String HOUSE_SEARCH_DELETE = "house_search_delete";
    // 使用Id查询房屋列表
    public static final String HOUSE_SEARCH_QUERY_BY_ID = "house_search_query_by_id";
    // 根据房屋id查询房屋列表
    public static final String HOUSE_SEARCH_QUERY_BY_HOUSE_ID = "house_search_query_by_house_id";
    // 查询房东下面有多少房屋
    public static final String HOUSE_SEARCH_QUERY_HOUSE_COUNT_BY_LANDLORD_ID = "house_search_query_house_count_by_landlord_id";
    // 查询房东下面有多少房屋id
    public static final String HOUSE_SEARCH_QUERY_HOUSE_ID_BY_LANDLORD_ID = "house_search_query_house_id_by_landlord_id";
    // 根据城市Id查询房屋列表
    public static final String HOUSE_SEARCH_QUERY_PART_INFO_BY_CITY_ID = "house_search_query_part_info_by_city_id";
    // 房屋搜索排名全量同步
    public static final String HOUSE_SEARCH_RANK_FAILURE = "根据房屋id查询搜索排名信息";

    /**
     * -------------dubbo房屋列表-------------
     */
    // 房屋列表查询
    public static final String DUBBO_HOUSE_SEARCH_QUERY = "dubbo_house_search_query";
    // 房屋列表更新
    public static final String DUBBO_HOUSE_SEARCH_UPDATE = "dubbo_house_search_update";
    // 房屋列表删除
    public static final String DUBBO_HOUSE_SEARCH_DELETE = "dubbo_house_search_delete";
    // 使用Id查询房屋列表
    public static final String DUBBO_HOUSE_SEARCH_QUERY_BY_ID = "dubbo_house_search_query_by_id";
    // 使用cityId查询房屋索引
    public static final String DUBBO_HOUSE_INDEX_QUERY_BY_CITY_ID = "dubbo_house_index_query_by_city_id";
    // 使用landlordId查询房屋索引
    public static final String DUBBO_HOUSE_INDEX_QUERY_BY_LANDLORD_ID = "dubbo_house_index_query_by_landlord_id";
    // 查询房屋索引 分页查询
    public static final String DUBBO_HOUSE_INDEX_QUERY_BY_HOUSE_ID_PAGESIZE = "dubbo_house_index_query_by_house_id_pagesize";
    // 根据房屋id查询房屋列表
    public static final String DUBBO_HOUSE_SEARCH_QUERY_BY_HOUSE_ID = "dubbo_house_search_query_by_house_id";
    // 根据房屋guid查询房屋列表
    public static final String DUBBO_HOUSE_SEARCH_QUERY_BY_HOUSE_GUID = "dubbo_house_search_query_by_house_guid";
    // 根据房屋信息查询房屋列表
    public static final String DUBBO_HOUSE_SEARCH_QUERY_BY_HOUSE_SEARCH = "dubbo_house_search_query_by_house_search";
    // 根据houseIds查询房屋列表
    public static final String DUBBO_HOUSE_SEARCH_QUERY_LIST_BY_HOUSE_IDS = "dubbo_house_search_query_list_by_house_ids";

    /**
     * ---------房屋费用dubbo调用-----
     */
    // 房屋费用插入
    public static final String DUBBO_HOUSE_CHARGE_QUERY_BY_HOUSEID = "dubbo_house_charge_query_by_houseid";
    // 房屋费用插入
    public static final String DUBBO_HOUSE_CHARGE_INSERT = "house_charge_insert";
    // 房屋费用更新
    public static final String DUBBO_HOUSE_CHARGE_UPDATE = "house_charge_update";
    // 房屋费用更新早餐
    public static final String DUBBO_HOUSE_CHARGE_UPDATE_BREAKFASTITEM = "house_charge_update_breakfastitem";
    // 房屋费用更新额外费用
    public static final String DUBBO_HOUSE_CHARGE_UPDATE_EXTRACHARGEITEM = "house_charge_update_extrachargeitem";
    // 房屋费用更新加人
    public static final String DUBBO_HOUSE_CHARGE_UPDATE_ADDPERSONITEM = "house_charge_update_addpersonitem";
    // 房屋费用更新押金设置
    public static final String DUBBO_HOUSE_CHARGE_UPDATE_DEPOSITITEM = "house_charge_update_deposititem";
    // 房屋费用更新是否支持信用免押设置
    public static final String DUBBO_HOUSE_CHARGE_UPDATE_SUPPORT_CREDIT = "dubbo_house_charge_update_support_credit";
    // 批量查询房屋费用根据房屋ID
    public static final String DUBBO_HOUSE_CHARGE_QUERY_BY_HOUSEIDS = "dubbo_house_charge_query_by_houseids";
    // 批量查询房屋费用根据房屋费用ID
    public static final String DUBBO_HOUSE_CHARGE_QUERY_BY_HOUSECHARGEIDS = "dubbo_house_charge_query_by_housechargeids";
    // 使用房屋ID查询日志
    public static final String DUBBO_HOUSE_QUERY_LOG = "dubbo_house_query_log";
    // 保存房屋日志
    public static final String DUBBO_HOUSE_SAVE_LOG = "dubbo_house_save_log";

    /**
     * --------房屋打分dubbo调用------
     */
    //根据房屋Id查询房屋分数
    public static final String DUBBO_HOUSE_SCORE_QUERY_BY_ID = "dubbo_house_score_query_by_id";
    //根据房屋Guid查询房屋分数
    public static final String DUBBO_HOUSE_SCORE_QUERY_BY_GUID = "dubbo_house_score_query_by_guid";


    /**
     * ---------房屋枚举dubbo调用-----
     */
    // 查询房屋设施枚举接口
    public static final String DUBBO_HOUSE_ENUM_QUERY_FACILITY_NOT_PARAMETER = "dubbo_house_enum_query_facility_not_parameter";
    // 根据 分类名 获取该分类下的所有枚举对象
    public static final String DUBBO_HOUSE_ENUM_QUERY_ALL_NOT_PARAMETER = "dubbo_house_enum_query_all_not_parameter";

    /**
     * ---------门店Service begin-----
     */
    // 新建门店
    public static final String HOTEL_INSERT = "hotel_insert";
    // 更新门店
    public static final String HOTEL_UPDATE = "hotel_update";
    // 使用CRM数据创建门店
    public static final String HOTEL_SAVE_BY_CRM_TAVERN = "hotel_save_by_crm_tavern";
    // 软删除门店
    public static final String HOTEL_DELETE = "hotel_delete";
    // 查询门店数量
    public static final String HOTEL_QUERY_COUNT = "hotel_query_count";
    // 查询门店列表
    public static final String HOTEL_QUERY_LIST = "hotel_query_list";
    // 使用ID查询门店
    public static final String HOTEL_QUERY_BY_ID = "hotel_query_by_id";
    // 使用房东ID查询门店数量
    public static final String HOTEL_QUERY_COUNT_BY_LANDLORD_ID = "hotel_query_count_by_landlord_id";
    // 使用Number查询门店
    public static final String HOTEL_QUERY_BY_NUMBER = "hotel_query_by_number";
    // 使用GUID查询门店
    public static final String HOTEL_QUERY_BY_GUID = "hotel_query_by_guid";
    // 更新门店不需要审核的字段
    public static final String HOTEL_UPDATE_NEEDLESS_AUDIT_INFO = "hotel_update_needless_audit_info";
    // 更新门店冗余的房东字段
    public static final String HOTEL_UPDATE_REDUNDANT_LANDLORD = "hotel_update_redundant_landlord";
    // 门店上下架操作
    public static final String HOTEL_UPDATE_ACTIVE = "hotel_update_active";
    // 增加门店日志
    public static final String HOTEL_INSERT_LOG = "hotel_insert_log";
    // 查询门店日志列表
    public static final String HOTEL_LOG_QUERY_LIST = "hotel_log_query_list";
    // 查询门店日志数量
    public static final String HOTEL_LOG_QUERY_COUNT = "hotel_log_query_count";
    /**---------门店 Service end-----*/

    /**
     * ---------门店 Dubbo Service begin-----
     */
    // 批量查询门店
    public static final String DUBBO_HOTEL_QUERY_PAGE_LIST = "dubbo_hotel_query_page_list";
    // 使用城市ID查询门店列表
    public static final String DUBBO_HOTEL_QUERY_BY_CITY_ID = "dubbo_hotel_query_by_city_id";
    // 使用ID查询门店
    public static final String DUBBO_HOTEL_QUERY_BY_ID = "dubbo_hotel_query_by_id";
    // 使用ID or 名称 查询门店
    public static final String DUBBO_HOTEL_QUERY_BY_ID_OR_NAME = "dubbo_hotel_query_by_id_or_name";
    // 使用ID查询门店 guid
    public static final String DUBBO_HOTEL_QUERY_GUID_BY_ID = "dubbo_hotel_query_guid_by_id";
    // 使用GUID查询门店
    public static final String DUBBO_HOTEL_QUERY_BY_GUID = "dubbo_hotel_query_by_guid";
    // 使用GUID s查询门店
    public static final String DUBBO_HOTEL_QUERY_BY_GUIDS = "dubbo_hotel_query_by_guids";
    // 使用门店ID查询日志
    public static final String DUBBO_HOTEL_QUERY_LOG = "dubbo_hotel_query_log";
    // 保存门店日志
    public static final String DUBBO_HOTEL_SAVE_LOG = "dubbo_hotel_save_log";
    //更新baseinfo独有的字段
    public static final String DUBBO_HOTEL_UPDATE_BASEINFO_ALONE = "dubbo_hotel_update_baseinfo_alone";
    // 保存不需要审核的门店字段
    public static final String DUBBO_HOTEL_UPDATE_NEEDLESS_AUDIT_INFO = "dubbo_hotel_update_needless_audit_info";
    // 查询不需要审核的门店字段
    public static final String DUBBO_HOTEL_QUERY_NEEDLESS_AUDIT_INFO = "dubbo_hotel_query_needless_audit_info";
    // 门店上下架操作
    public static final String DUBBO_HOTEL_UPDATE_ACTIVE = "dubbo_hotel_update_active";
    //根据分机号查询门店可联系到的电话
    public static final String DUBBO_HOTEL_QUERY_CONTACT_PHONE = "dubbo_hotel_query_contact_phone";

    //根据房东id查询门店id列表
    public static final String DUBBO_HOTEL_LIST_HOTEL_ID_BY_LANFLORD_ID = "dubbo_hotel_list_hotel_id_by_landlord_id";
    //根据客服id查询门店id列表
    public static final String DUBBO_HOTEL_LIST_HOTEL_ID_BY_CUSTOM_SERVICE_ID = "dubbo_hotel_list_hotel_id_by_custom_service_id";
    // 保存房屋非审核字段
    public static final String DUBBO_HOTEL_UPDATE_NEEDLESS_AUDIT_INFO_API = "dubbo_hotel_update_needless_audit_info_api";
    //插入门店
    public static final String DUBBO_HOTEL_SAVE = "dubbo_hotel_save";
    // 同步保存房屋系统门店数据
    public static final String SYNC_SAVE_MERCHANT_HOTEL = "sync_save_merchant_hotel";
    //门店id集合查询门店列
    public static final String DUBBO_HOTEL_QUERY_BY_IDS = "dubbo_hotel_query_by_ids";

    public static final String DUBBO_HOTEL_CACHE_CLEAR = "dubbo_hotel_cache_clear";

    public static final String DUBBO_HOUSE_CACHE_CLEAR = "dubbo_house_cache_clear";

    public static final String DUBBO_LANDLORD_CACHE_CLEAR = "dubbo_landlord_cache_clear";
    /**---------门店 Dubbo Service end-----*/

    /**
     * ----------供应商 Dubbo Service begin-----
     */
    //根据供应商ID查询供应商信息
    public static final String DUBBO_PACKAGING_SUPPLIER_QUERY_BY_ID = "dubbo_packaging_supplier_query_by_id";
    //查询供应商列表
    public static final String DUBBO_PACKAGING_SUPPLIER_QUERY_LIST = "dubbo_packaging_supplier_query_list";
    //查询需要导出的供应商列表
    public static final String DUBBO_PACKAGING_SUPPLIER_QUERY_LIST_FOREXPORT = "dubbo_packaging_supplier_query_list_forexport";
    //保存供应商信息
    public static final String DUBBO_PACKAGING_SUPPLIER_SAVE = "dubbo_packaging_supplier_save";
    //更新供应商信息
    public static final String DUBBO_PACKAGING_SUPPLIER_UPDATE = "dubbo_packaging_supplier_update";
    //批量禁用供应商
    public static final String DUBBO_PACKAGING_SUPPLIER_FORBID = "dubbo_packaging_supplier_forbid";
    //批量激活供应商
    public static final String DUBBO_PACKAGING_SUPPLIER_ACTIVE = "dubbo_packaging_supplier_active";
    //批量删除供应商
    public static final String DUBBO_PACKAGING_SUPPLIER_DELETE_SOME = "dubbo_packaging_supplier_delete_some";
    //查询合同即将过期的供应商
    public static final String DUBBO_PACKAGING_SUPPLIER_CONTRACT_NEAR = "dubbo_packaging_supplier_contract_near";
    //查询合同已经过期的供应商
    public static final String DUBBO_PACKAGING_SUPPLIER_CONTRACT_OVER = "dubbo_packaging_supplier_contract_over";
    //查询合同已经过期（即将过期）的供应商数量
    public static final String DUBBO_PACKAGING_SUPPLIER_CONTRACT_COUNT = "dubbo_packaging_supplier_contract_count";
    //查询供应商操作日志
    public static final String DUBBO_PACKAGING_SUPPLIER_QUERY_LOG = "dubbo_packing_supplier_query_log";
    //插入供应商操作日志
    public static final String DUBBO_PACKAGING_SUPPLIER_INSERT_LOG = "dubbo_packing_supplier_insert_log";


    /**-----------供应商 Dubbo Service end-----*/

    /**
     * ---------房东 Service begin-----
     */
    // 根据房东ID查询房东信息
    public static final String LANDLORD_QUERY_BY_ID = "landlord_query_by_id";
    // 根据资质编号查询房东信息
    public static final String LANDLORD_QUERY_BY_QUALIFICATION_NUMBER = "landlord_query_by_qualification_number";
    // 新增房东
    public static final String LANDLORD_INSERT = "landlord_insert";
    // 更新房东信息
    public static final String LANDLORD_UPDATE = "landlord_update";
    // 根据房东ID更新字段RBA值
    public static final String LANDLORD_UPDATE_RBA_BY_ID = "landlord_update_rba_by_id";
    // 根据房东ID删除房东信息
    public static final String LANDLORD_DELETE_BY_ID = "landlord_delete_by_id";
    // 查询符合条件的房东总条数
    public static final String LANDLORD_TOTAL_SIZE = "Landlord_total_size";
    // 查询房东列表
    public static final String LANDLORD_QUERY_LIST = "landlord_query_list";
    // 新增房东操作日志
    public static final String LANDLORDLOG_INSERT = "landlordlog_insert";
    // 查询房东日志列表
    public static final String LANDLORD_LOG_QUERY_LIST = "landlord_log_query_list";
    // 查询房东日志数量
    public static final String LANDLORD_LOG_QUERY_COUNT = "landlord_log_query_count";
    // 判断是否为新房东
    public static final String LANDLORD_JUDGE_IS_NEW = "landlord_judge_is_new";

    // 使用CRM资质创建房东
    public static final String LANDLORD_SAVE_BY_CRM_QULIFICATION = "landlord_save_by_crm_qualification";
    /**---------房东 Service end-----*/

    /**
     * ---------房东 Dubbo Service begin-----
     */
    public static final String DUBBO_LANDLORD_SERVICE_ADD = "dubbo_landlord_service_add";
    public static final String DUBBO_LANDLORD_SERVICE_QUERY_BY_ID = "dubbo_landlord_service_query_by_id";
    public static final String DUBBO_LANDLORD_SERVICE_QUERY_BY_GUID = "dubbo_landlord_service_query_by_guid";
    public static final String DUBBO_LANDLORD_SERVICE_QUERY_BY_HOTEL_ID = "dubbo_landlord_service_query_by_hotel_id";
    public static final String DUBBO_LANDLORD_SERVICE_MODIFY = "dubbo_landlord_service_modify";
    public static final String SYNC_MERCHANT_QUALIFICATION_INFO = "sync_merchant_qualification_info";
    public static final String DUBBO_LANDLORD_SERVICE_QUERY_IS_NEW_LANDLORD_BY_ID = "dubbo_landlord_servie_query_is_new_landlord_by_id";
    public static final String DUBBO_LANDLORDLOG_SERVICE_QUERY_LIST_BY_LANDLORDID = "dubbo_landlordlog_servie_query_list_by_landlordid";
    public static final String DUBBO_LANDLORD_SERVICE_LIST = "dubbo_landlord_service_list";

    //通过房东Id列表查询房东信息列表
    public static final String DUBBO_LANDLORD_QUERY_LIST_BY_LANDLORD_ID_LIST = "dubbo_landlord_query_list_by_landlord_id_list";
    /**---------房东 Dubbo Service end-----*/

    /**
     * ---------城市dubbo调用-----
     */
    // 根据城市三个区域信息查询对应的城市名或区名
    public static final String DUBBO_QUERY_CITY_AND_AREA_BY_ID = "dubbo_query_city_and_area_by_id";

    public static final String SLOW_SQL_COST_TIME = "slow_sql_cost_time";
    public static final String SQL_COST_TIME = "sql_cost_time";
    public static final String DB_EXCEPTION = "db_exception";
    public static final String TEST_TASK_RUN_EXCEPTION = "test_task_run_exception";

    /**
     * -----------------------消息队列消费相关-----------------------
     */
    public static final String NOTIFY_CRMHOUSE_BASEINFO_FOR_API_RECEIVER = "notify_crmhouse_baseinfo_for_api_receiver";
    public static final String NOTIFY_QUALIFICATION_BASEINFO_FOR_API_RECEIVER = "notify_qualification_baseinfo_for_api_receiver";
    public static final String NOTIFY_CRM_HOTEL_BASE_INFO_RECEIVER = "notify_crm_hotel_base_info_receiver";

    // 房东变更事件
    public static final String SUBSCRIBE_LANDLORD_CHANGE = "subscribe_landlord_change";
    // 房屋变更事件
    public static final String SUBSCRIBE_HOUSEINFO_CHANGE = "subscribe_houseinfo_change";

    /***
     * Tedis 相关，未特殊标明的，只有 Success 的计时。 另外，当一个指标的 Failure 和 Exception 同时出现时，不同于上面业务相关的监控，这里的 Exception 并不是 Failure
     * 的子集，但是有交集。
     */
    public static final String TEDIS_INVOKE_EXCEPTION = "Tedis_Invoke_Exception";
    // Tedis调用成功
    public static final String TEDIS_INVOKE_SUCCESS = "Tedis_Invoke_Success";
    // Tedis命中失败
    public static final String TEDIS_INVOKE_HIT_FAILURE = "Tedis_Invoke_Hit_Failure";
    // Tedis命中成功
    public static final String TEDIS_INVOKE_HIT_SUCCESS = "Tedis_Invoke_Hit_Success";

    // 增加白名单
    public static final String WHITE_LIST_INSERT = "white_list_insert";
    // 查询白名单
    public static final String WHITE_LIST_SELECT = "white_list_select";
    // 检查资质编号是否在白名单中
    public static final String WHITE_LIST_CHECK = "white_list_check";
    // 检查资质GlobalID是否在白名单中Dubbo
    public static final String DUBBO_WHITE_LIST_CHECK_QUALIFICATION = "dubbo_white_list_check_qualification";
    // 检查门店GlobalID是否在白名单中Dubbo
    public static final String DUBBO_WHITE_LIST_CHECK_HOTEL = "dubbo_white_list_check_hotel";
    // 检查房屋GlobalID是否在白名单中Dubbo
    public static final String DUBBO_WHITE_LIST_CHECK_HOUSE = "dubbo_white_list_check_house";

    /**
     * ---------汇率同步-----
     */
    public static final String GET_EXCHANGE_RATE_INFO = "http_get_exchange_rate_info";
    public static final String DUBBO_GET_EXCHANGE_RATE_INFO = "dubbo_get_exchange_rate_info";
    /**
     * ---------bi优选同步-----
     */
    public static final String ADD_REPORT_UNIT_OPTIMIZATION_CHANGE_DIFF_DATA_FROM_BI = "add_report_unit_optimization_change_diff_data_from_bi";

    /**
     * ---------分销渠道-----
     */
    public static final String DUBBO_UPDATE_DISTRIBUTION_CHANNEL = "dubbo_update_distribution_channel";
    public static final String DUBBO_ADD_DISTRIBUTION_CHANNEL = "dubbo_add_distribution_channel";
    public static final String DUBBO_DELETE_DISTRIBUTION_CHANNEL = "dubbo_delete_distribution_channel";

    /**
     * ------房屋评分-----
     */
    public static final String DUBBO_SAVE_OR_UPDATE_HOUSE_SCORE = "dubbo_save_or_update_house_score";
    public static final String DUBBO_QUERY_HOUSE_SCORE_BY_GUID = "dubbo_query_house_score_by_guid";

    /**
     *  ----房屋优选
     */
    public static final String DUBBO_QUERY_HOUSE_PREFERENCE_BY_ID = "dubbo_query_house_preference_by_id";

    /**==========================================================================================================*/
    //报表相关
    /**
     * 初始化门店优选数据监控
     */
    public static final String INIT_REPORT_MERCHANT_PREFERENCE = "init_report_merchant_preference";

    /**
     * 获取门店优选报表数据
     */
    public static final String GET_REPORT_MERCHANT_PREFERENCE_LIST = "get_report_merchant_preference_list";

    /**
     * 查询门店优选报表数据
     */
    public static final String GET_REPORT_MERCHANT_PREFERENCE_BY_HOTELID = "getReportMerchantPreferenceByHotelId";

    /**
     * 获取房屋优选报表数据
     */
    public static final String QUERY_REPORT_UNIT_OPTIMIZATION_BY_HOTELID = "queryReportUnitOptimizationByHotelId";

    /**
     * 查询房屋优选数据总数
     */
    public static final String QUERY_REPORT_UNIT_OPTIMIZATION_BY_HOTELID_COUNT = "queryReportUnitOptimizationByHotelIdCount";

    /**
     * 通过门店id查询房屋优选数据
     */
    public static final String QUERY_REPORT_UNIT_OPTIMIZATION_BY_UNITID = "queryReportUnitOptimizationByUnitId";

    /**
     * 通过门店ids批量查询房屋优选数据
     */
    public static final String QUERY_REPORT_UNIT_OPTIMIZATION_BY_UNITIDS = "queryReportUnitOptimizationByUnitIds";

    /**
     * 添加房屋优选(全量数据)
     */
    public static final String ADD_REPORT_UNIT_OPTIMIZATION_RES_DATA_FROM_BI = "addReportUnitOptimizationResDataFromBI";

    /**
     * 添加房屋优选(增量数据)
     */
    public static final String ADD_REPORT_UNIT_OPTIMIZATION_DIFF_DATA_FROM_BI = "addReportUnitOptimizationDiffDataFromBI";

    /**
     * 获取房屋优选
     */
    public static final String GET_REPORT_UNIT_OPTIMIZATION_LIST = "getReportUnitOptimizationList";

    public static final String TASK_MERCHANT_PREFERENCE_DIFF_TASK_FAIL = "DealWithReportMerchantPreferenceDiffDataTask";

    public static final String TASK_MERCHANT_PREFERENCE_RES_TASK_FAIL = "DealWithReportMerchantPreferenceResDataTask";

    public static final String TASK_UNIT_OPTIMIZATION_DIFF_TASK_FAIL = "DealWithReportUnitOptimizationDiffDataTask";
    public static final String TASK_UNIT_OPTIMIZATION_RES_TASK_FAIL = "DealWithReportUnitOptimizationResDataTask";

    /**
     * ---------黑名单-----
     */
    // 保存/更新 黑名单
    public static final String DUBBO_BLACKLIST_SAVE_OR_UPDATE = "dubbo_blacklist_save_or_update";
    // 查询 黑名单
    public static final String DUBBO_BLACKLIST_QUERY = "dubbo_blacklist_query";

    public static final String DUBBO_HOTEL_FAST_BOOKING_DETAIL = "dubbo_hotel_fast_booking_detail";

    /**
     * ---------task-----
     */
    // 房屋位置得分同步任务
    public static final String TASK_HOUSE_AREA_SCORE_SYNC = "task_house_area_score_sync";
    // 门店优选全量同步
    public static final String TASK_HOTEL_PREFERENCE_SYNC = "task_hotel_preference_sync";
    // 房屋优选全量同步
    public static final String TASK_HOUSE_PREFERENCE_SYNC = "task_house_preference_sync";
    // 汇率同步
    public static final String TASK_EXCHANGE_RATE_SYNC = "task_exchange_rate_sync";
    // 门店闪订数据同步任务
    public static final String TASK_HOTEL_FAST_BOOKING_SWITCH_SYNC = "task_hotel_fast_booking_switch_sync";
    // 更新房东缓存task
    public static final String TASK_LANDLORD_REFRESH_CACHE = "task_landlord_refresh_cache";
    // 更新门店缓存task
    public static final String TASK_HOTEL_REFRESH_CACHE = "task_hotel_refresh_cache";
    // 更新房屋缓存task
    public static final String TASK_HOUSE_REFRESH_CACHE = "task_house_refresh_cache";
    // 更新房屋搜索模型缓存task
    public static final String TASK_HOUSE_SEARCE_REFRESH_CACHE = "task_house_search_refresh_cache";
    // 更新房屋价格缓存task
    public static final String TASK_HOUSE_CHARGE_REFRESH_CACHE = "task_house_charge_refresh_cache";

}
