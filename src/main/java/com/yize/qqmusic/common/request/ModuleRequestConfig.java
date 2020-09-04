package com.yize.qqmusic.common.request;

public interface ModuleRequestConfig {
    public static final String ROOT_AB_TEST = "abtest.";
    public static final String ROOT_ASSET = "Asset.";
    public static final String ROOT_BIG_DAY = "BigDay.BigDayAdvertServer";
    public static final String ROOT_CONCERN = "Concern.";
    public static final String ROOT_FEATURE = "Feature.";
    public static final String ROOT_LIVE = "live_radio.";
    public static final String ROOT_LIVE_SHOW = "qqmusic.liveShow.";
    public static final String ROOT_LULLABY = "lullaby.";
    public static final String ROOT_MAGAZINE = "magzine.";
    public static final String ROOT_MUSIC = "music.";
    public static final String ROOT_MUSICHALL = "musichall.";
    public static final String ROOT_MUSIC_HALL_VIP = "MusichallVip.";
    public static final String ROOT_MUSIC_LIVE = "music_live.";
    public static final String ROOT_MV_SERVICE = "MvService.";
    public static final String ROOT_ORDER = "VipOrder.";
    public static final String ROOT_PLAYLIST = "playlist.";
    public static final String ROOT_PORTAL = "portal.";
    public static final String ROOT_RCMUSIC = "rcmusic.";
    public static final String ROOT_RUNNING_RADIO = "RunRadio.";
    public static final String ROOT_SIMPLE_LIVE_SHOW = "liveShow.";
    public static final String ROOT_THEME = "Personal.";
    public static final String ROOT_TRACKINFO = "track_info.";
    public static final String ROOT_UNITE_CONFIG = "UniteConfig.";
    public static final String ROOT_USERINFO = "userInfo.";
    public static final String ROOT_VIEW_ACTION = "ViewAction.";
    public static final String ROOT_VIP_CENTER = "VipCenter.";
    public static final String ROOT_VKEY = "vkey.";
    public static final String ROOT_WEIYUN_MUSIC = "WeiyunMusic.";

    public interface ABTest {
        public static final String GET_STRATEGY = "get_native_strategy";
        public static final String MODULE = "abtest.ABTestStrategyServer";
    }

    public interface AITrackSimilarityServer {
        public static final String METHOD = "get_smart_similarity_track";
        public static final String MODULE = "music.ai_track_similarity_svr";
    }

    public interface ActionAlert {
        public static final String ACTION_ALERT = "fcg_action_alter";
        public static final String MODULE = "ViewAction.ViewActionAlterServer";
    }

    public interface AiFeedbackServer {
        public static final String METHOD_GET_DISLIKE_REASON = "get_dis_fb_message";
        public static final String METHOD_GET_DISLIKE_REASON_BATCH = "get_dis_fb_message_batch";
        public static final String METHOD_SEND_DISLIKE_FEEDBACK = "report_fb";
        public static final String MODULE = "music.ai_feedback_svr";
    }

    public interface AiTrackDaily {
        public static final String GET_DAILY_TRACK = "get_daily_track";
        public static final String MODULE = "music.ai_track_daily_svr";
    }

    public interface AlbumPgcMgrServer {
        public static final String GET_MUSIC_HALL_ALBUM_ENTRY = "GetMusicHallAlbumEntry";
        public static final String MODULE = "mall.AlbumPgcMgrServer";
    }

    public interface BaseLogin {
        public static final String METHOD = "CallBasicInfo";
        public static final String MODULE = "login.BasicinfoServer";
    }

    public interface BindSinaServer {
        public static final String BIND = "bind";
        public static final String METHOD = "set_user_weibo_info";
        public static final String MODULE = "userInfo.BaseUserInfoServer";
        public static final String NICK = "nick";
        public static final String UID = "uid";
    }

    public interface CgiGetDownUrl {
        public static final String METHOD = "CgiGetDownUrl";
        public static final String MODULE = "vkey.GetDownUrlServer";
    }

    public interface CgiGetVkey {
        public static final String METHOD = "CgiGetVkey";
        public static final String MODULE = "vkey.GetVkeyServer";
    }

    public interface CleanCache {
        public static final String METHOD = "getRecommend";
        public static final String MODULE = "MusicPlatform.CleanDiskRecommend";
    }

    public interface CommonFavServer {
        public static final String FAV = "status";
        public static final String ITEM_ID = "item_id";
        public static final String METHOD = "set_user_star";
        public static final String MODULE = "star.MusicStarServer";
        public static final String ZID = "biz_id";
    }

    public interface ConcernSystemServer {
        public static final String BUSINESS_ID = "bussinessid";
        public static final String BUSINESS_TYPE = "bussinesstype";
        public static final String METHOD = "cgi_concern_user_v2";
        public static final String MODULE = "Concern.ConcernSystemServer";
        public static final String OPERATE_TYPE = "opertype";
        public static final String SOURCE = "source";
        public static final String USER_ID = "userid";
        public static final String USER_INFO = "userinfo";
        public static final String USER_TYPE = "usertype";
    }

    @Deprecated
    public interface DailyFolderEntrance {
        public static final String GET_ENTRANCE = "getDailyDiscoveriesEntrance";
        public static final String MODULE = "gosrf.Recommend.DailyDiscoveriesEntrance";
    }

    public interface DiscoveryFeedServer {
        public static final String DIRECTION = "direction";
        public static final String METHOD = "get_feed";
        public static final String MODULE = "magzine.DiscoveryFeedServer";
        public static final String REPORT = "report";
        public static final String TAB = "tab";
    }

    public interface DiscoveryRecommendServer {
        public static final String CMD = "cmd";
        public static final String METHOD = "get_recommend_plugin";
        public static final String MODULE = "magzine.DiscoveryRecommendServer";
    }

    public interface Dislike {
        public static final String METHOD_DISLIKE_SINGER = "add_singer_blacklist";
        public static final String METHOD_DISLIKE_SONG = "add_dislike_track";
        public static final String MODULE = "radio_dustbin.RadioDustbinDataServer";
    }

    public interface FeedDetailServer {
        public static final String CMD = "cmd";
        public static final String FEED_ID = "moid";
        public static final String METHOD = "get_moment_detail";
        public static final String MODULE = "magzine.MomentReadServer";
        public static final String NEED_RELATED_SONGS = "video_track_opt";
    }

    public interface FreeFlow {
        public static final String METHOD_AUTH_IMUSIC = "GetOutJce";
        public static final String METHOD_AUTH_UNICOM = "GetServerRespondJson";
        public static final String MODULE_IMUSIC = "Imusic.ImusicQueryServer";
        public static final String MODULE_UNICOM = "UnicomGetSub.UnicomGetSubedproductsServer";
    }

    public interface GetAdInfo {
        public static final String METHOD = "get_adinfo";
        public static final String MODULE = "MvActivity.VideoPosterServer";
    }

    public interface GetAssFile {
        public static final String METHOD = "GetAssLyric";
        public static final String MODULE = "vision.LyricEffectsServer";
    }

    public interface GetAssXEffectList {
        public static final String METHOD = "GetEffectsList";
        public static final String MODULE = "vision.LyricEffectsServer";
    }

    public interface GetBannel {
        public static final String METHOD = "GetBannel";
        public static final String MODULE = "BigDay.BigDayAdvertServer";
    }

    public interface GetBrand {
        public static final String METHOD = "PrePullAdvert";
        public static final String MODULE = "BigDay.BigDayAdvertServer";
    }

    public interface GetIntelligentServer {
        public static final String FORCE = "force";
        public static final String GET_INTELLIGENT_TAG_LIST = "GetIntelligentTagList";
        public static final String INTELLIGENT_TAG_SONG_INFO = "IntelligentTagSongInfo";
        public static final String MODULE = "IntelligentTagServer";
        public static final String REMOVE_INTELLIGENT_TAG = "RemoveIntelligentTag";
        public static final String SAVE_INTELLIGENT_TAG = "SaveIntelligentTag";
        public static final String TAGID = "tagid";
        public static final String TAGIDS = "tagids";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";
    }

    public interface GetPenDant {
        public static final String METHOD = "GetPendant";
        public static final String MODULE = "BigDay.BigDayAdvertServer";
    }

    public interface GetProfileCoop {
        public static final String METHOD = "get_cooplist";
        public static final String MODULE = "userInfo.BaseUserInfoServer";
    }

    public interface GetShareInfo {
        public static final String METHOD = "gen_poster_url";
        public static final String MODULE = "MvActivity.VideoSharePosterServer";
    }

    public interface GetVideoUrls {
        public static final String METHOD = "GetMvUrls";
        public static final String MODULE = "gosrf.Stream.MvUrlProxy";
        public static final String REQUEST_QUALITY = "filetype";
        public static final String REQUEST_TYPE = "request_type";
        public static final String VIDEO_FORMAT = "videoformat";
        public static final String VIDS = "vids";
    }

    public interface GetWhiteListH5 {
        public static final String METHOD = "GetAllSonglistIdAdvert";
        public static final String MODULE = "AdvertH5.AdvertH5BaseServer";
    }

    public interface HippyServer {
        public static final String GET_BUNDLE = "get_bundle";
        public static final String MODULE = "Feature.HippyServer";
    }

    public interface ImClearSession {
        public static final String METHOD = "ClearSession";
        public static final String MODULE = "PrivateMsg.PrivateMsgWriteServer";
        public static final String SESSION_ID = "session_id";
    }

    public interface ImDeleteMessage {
        public static final String METHOD = "DeleteMessage";
        public static final String MODULE = "PrivateMsg.PrivateMsgWriteServer";
        public static final String MSG_ID = "msg_id";
        public static final String SESSION_ID = "session_id";
    }

    public interface ImGetBlackList {
        public static final String METHOD = "GetBlackList";
        public static final String MODULE = "PrivateMsg.PrivateMsgReadServer";
    }

    public interface ImGetConfig {
        public static final String CONFIG_TYPE = "config_type";
        public static final String CONFIG_VALUE_STR = "config_value_str";
        public static final String METHOD = "GetConfig";
        public static final String MODULE = "PrivateMsg.PrivateMsgReadServer";
    }

    public interface ImMessageList {
        public static final String LAST_ID = "last_id";
        public static final String METHOD = "GetMessage";
        public static final String MODULE = "PrivateMsg.PrivateMsgReadServer";
        public static final String ORDER = "order";
        public static final String SESSION_ID = "session_id";
        public static final String SIZE = "size";
        public static final String USER_ID = "user_id";
    }

    public interface ImSendMessage {
        public static final String CLIENT_KEY = "client_key";
        public static final String DATA_TYPE = "data_type";
        public static final String ENTRANCE = "entrance";
        public static final String LAST_ID = "last_id";
        public static final String LAST_SEQUENCE = "last_sequence";
        public static final String META_DATA = "meta_data";
        public static final String METHOD = "SendMessage";
        public static final String MODULE = "PrivateMsg.PrivateMsgWriteServer";
        public static final String MSG_ID = "msg_id";
        public static final String SESSION_ID = "session_id";
        public static final String USER_ID = "user_id";
        public static final String USER_INPUT = "user_input";
    }

    public interface ImSessionDelete {
        public static final String METHOD = "DeleteSession";
        public static final String MODULE = "PrivateMsg.PrivateMsgWriteServer";
        public static final String SESSION_ID = "session_id";
    }

    public interface ImSessionGet {
        public static final String LAST_ID = "last_id";
        public static final String LAST_TIME = "last_time";
        public static final String METHOD = "GetSessionList";
        public static final String MODULE = "PrivateMsg.PrivateMsgReadServer";
        public static final String ORDER = "order";
        public static final String SIZE = "size";
    }

    public interface ImSetConfig {
        public static final String CONFIG_TYPE = "config_type";
        public static final String CONFIG_VALUE = "config_value";
        public static final String CONFIG_VALUE_STR = "config_value_str";
        public static final String METHOD = "SetConfig";
        public static final String MODULE = "PrivateMsg.PrivateMsgWriteServer";
    }

    public interface LiveGiftListServer {
        public static final String ANIM_METHOD = "get_gift_animation";
        public static final String LAST_GIFT = "lastfreegid";
        public static final String LIST_METHOD = "get_gift_list";
        public static final String MODULE = "live_radio.LiveGiftListServer";
        public static final String PLATFORM = "platform";
        public static final String SHOW_ID = "showid";
        public static final String UPDATE_TIME = "updatetime";
    }

    public interface LiveGiftRankServer {
        public static final String GET_RANK_LIST_INFO = "GetAnchorRankTab";
        public static final String MODULE = "qqmusic.liveShow.LiveShowBubbleSvr";
        public static final String PARAM_SHOW_ID = "showid";
    }

    public interface LiveGiftServer {
        public static final String BILL_NUM = "billno";
        public static final String FROM_TAG = "fromtag";
        public static final String GIFT_ID = "giftid";
        public static final String GIFT_NUM = "giftnum";
        public static final String HORN_METHOD = "send_horn_wrapper";
        public static final String IDENTIFIER = "identifier";
        public static final String MESSAGE = "msg";
        public static final String MODULE = "live_radio.LiveGiftServer";
        public static final String SEND_GIFT_METHOD = "SendLiveGift";
        public static final String SHOW_ID = "showid";
    }

    public interface LiveLinkServer {
        public static final String CONN = "conn";
        public static final String GET_ANCHOR_LIST = "get_anchor_list";
        public static final String GET_CURRENT_STATUS = "get_curr_status";
        public static final String GET_PK_GIFT_RANK_LIST = "get_pk_gift_rank_list";
        public static final String MODULE = "Live.MicrophoneConn";
    }

    public interface LiveList {
        public static final String GET_LIVE_LIST = "get_living_list";
        public static final String MODULE = "music.livelist";
    }

    public interface LiveMissionServer {
        public static final String ANSWER = "answer";
        public static final String METHOD_ANSWER = "answer_question";
        public static final String METHOD_ENTRY = "get_mission_entry";
        public static final String METHOD_LIFE_CARD = "use_life_card";
        public static final String METHOD_MISSION_ROOM = "get_mission_room_info";
        public static final String MODULE = "music.live_mission_room";
        public static final String QUESTION_INDEX = "index";
        public static final String SHOW_ID = "showid";
    }

    public interface LiveRoomServer {
        public static final String METHOD = "push_tips_msg";
        public static final String MODULE = "music.live_room";
        public static final String SHOW_ID = "showid";
    }

    public interface LiveShowBubbleServer {
        public static final String GET_PENDANT = "GetPendant";
        public static final String GET_RANK_BUBBLE = "GetRankBubble";
        public static final String MODULE = "qqmusic.liveShow.LiveShowBubbleSvr";
    }

    public interface LiveShowBulletServer {
        public static final String METHOD_GET_NOTICE = "GetNotice";
        public static final String METHOD_SET_NOTICE = "SetNotice";
        public static final String MODULE = "qqmusic.liveShow.LiveShowBulletSvr";
        public static final String PARAM_MSG = "msg";
        public static final String PARAM_SHOW_ID = "showid";
    }

    public interface LiveShowGiftSvr {
        public static final String METHOD = "GetGiftPanel";
        public static final String METHOD_ANIMATION = "GetGiftAnimation";
        public static final String MODULE = "liveShow.LiveShowGiftSvr";
        public static final String PARAM_SHOW_ID = "showid";
    }

    public interface LiveShowGrantSvr {
        public static final String BILLNO = "billno";
        public static final String GIFT_ID = "giftid";
        public static final String GIFT_NUM = "giftnum";
        public static final String GROUPID = "groupid";
        public static final String IDENTIFIER = "identifier";
        public static final String METHOD = "SendLiveGift";
        public static final String MODULE = "liveShow.LiveShowGrantSvr";
        public static final String MULTIHIT = "multihit";
        public static final String SHOW_ID = "showid";
        public static final String TASKID = "taskid";
    }

    public interface LiveShowMsgSvr {
        public static final String GIFT_ID = "giftid";
        public static final String GIFT_NUM = "giftnum";
        public static final String GROUP_ID = "groupid";
        public static final String METHOD = "StopMultiHit";
        public static final String MODULE = "qqmusic.liveShow.LiveShowMsgSvr";
        public static final String MULTIHIT = "multihit";
        public static final String SHOW_ID = "showid";
        public static final String TASKID = "taskid";
        public static final String TOKEN = "token";
    }

    public interface LiveShowReportSvr {
        public static final String METHOD = "EnterShow";
        public static final String METHOD_HEARTBEAT = "HeartBeat";
        public static final String METHOD_LEAVE = "ExitShow";
        public static final String MODULE = "liveShow.LiveShowReportSvr";
        public static final String PARAM_DATA = "data";
        public static final String PARAM_IS_FIRST_HEART = "isfirst";
        public static final String PARAM_SHOW_ID = "showid";
    }

    public interface LoginResource {
        public static final String METHOD = "get_material";
        public static final String MODULE = "portal.PortalMaterialServer";
    }

    public interface LullabyAssetReadServer {
        public static final String GET_FAV_PLAYLIST = "get_fav_playlist";
        public static final String GET_FAV_SONG = "get_fav_song";
        public static final String MODULE = "lullaby.LullabyAssetReadServer";
    }

    public interface LullabyAssetWriteServer {
        public static final String FAV_PLAYLIST = "fav_playlist";
        public static final String FAV_SONG = "fav_song";
        public static final String MODULE = "lullaby.LullabyAssetWriteServer";
    }

    public interface LullabyCheckInServer {
        public static final String CHECK_IN = "check_in";
        public static final String MODULE = "lullaby.LullabyCheckInServer";
    }

    public interface LullabyReportServer {
        public static final String MODULE = "lullaby.LullabyReportServer";
        public static final String REPORT = "report";
    }

    public interface MVFeeds {
        public static final String GET_MV_URL = "GetVideoFeedsUrl";
        public static final String MODULE = "Base.VideoFeedsUrlServer";
    }

    public interface MVRecommendServer {
        public static final String METHOD = "GetMvRecWithList";
        public static final String MODULE = "MvService.MvInfoProServer";
        public static final String PARAM_VIDS = "mvids";
    }

    public interface MagzineDiscoveryServer {
        public static final String FANCY_ID = "fancy_id";
        public static final String LOCATION = "location";
        public static final String METHOD = "get_discovery_banner";
        public static final String METHOD_TAB = "get_discovery_tab";
        public static final String MODULE = "magzine.MagzineDiscoveryServer";
    }

    public interface MagzineOptServer {
        public static final String CMD = "cmd";
        public static final String METHOD = "report_opt";
        public static final String MODULE = "magzine.MagzineOptServer";
        public static final String READ_DURATION = "read_duration";
        public static final String READ_PERCENT = "read_percent";
        public static final String ZID = "zid";
    }

    public interface MomentAssertServer {
        public static final String CMD = "cmd";
        public static final String CURRENT_MOID = "cur_moid";
        public static final String HOST_UIN = "hostuin";
        public static final String LAST_MOID = "last_moid";
        public static final String METHOD = "get_create_info";
        public static final String MODULE = "magzine.MomentAssetServer";
        public static final String PAGE_SIZE = "page_size";
        public static final String PROFILE_VIDEO_METHOD = "get_create_video_moment_new";
        public static final String SID = "sid";
        public static final String SINCE = "sin";
        public static final String SIZE = "size";
        public static final String STYPE = "stype";
    }

    public interface MomentTrendServer {
        public static final String CMD = "cmd";
        public static final String METHOD = "get_moment_trend";
        public static final String METHOD_RED_DOT = "get_red_dot";
        public static final String MODULE = "magzine.MomentTrendServer";
        public static final String RED_DOT_TIMESTAMP = "timestamp";
    }

    public interface MrcFavorSysRead {
        public static final String GET_FAVOR_LIST = "get_favor_list";
        public static final String MODULE = "music.favor_system_read";
    }

    public interface MrcFavorSysWrite {
        public static final String DO_FAVOR = "do_favor";
        public static final String MODULE = "music.favor_system_write";
    }

    public interface MrcHotRecommend {
        public static final String DISLIKE_DISS = "dislike_diss";
        public static final String GET_NEW_HOT_RECOMMEND = "get_new_hot_recommend";
        public static final String MODULE = "playlist.HotRecommendServer";
    }

    public interface MrcLiveList {
        public static final String ASYNC_GET_YYG_VIDEO_LIST = "async_get_yyg_video_list";
        public static final String METHOD_GET_LIVE_RADIO_LIST = "get_live_radio_list";
        public static final String MODULE = "music.livelist";
    }

    public interface MrcMusicHall {
        public static final String GET_GROUP_COLUMN = "get_group_column";
        public static final String GET_GROUP_FOCUS = "get_group_focus";
        public static final String GET_GROUP_LIST = "get_group_list";
        public static final String GET_GROUP_MUSICIAN = "get_group_musician";
        public static final String GET_GROUP_NEW_ALBUM = "get_group_new_album";
        public static final String GET_GROUP_NEW_SONG = "get_group_new_song";
        public static final String GET_GROUP_PORTAL = "get_group_portal";
        public static final String GET_GROUP_RADIO = "get_group_radio";
        public static final String MODULE = "music.mb_musichall_svr";
    }

    public interface MrcMvService {
        public static final String GET_MUSICHALL_MV_REC = "GetMusichallMvRec";
        public static final String GET_MV_INFO = "GetMvInfoList";
        public static final String MODULE = "MvService.MvInfoProServer";
        public static final String REPLACE_MV = "ReplaceMv";
    }

    public interface MrcRadioData {
        public static final String METHOD_GET_ANCHOR_RADIO = "GetAnchorTitle";
        public static final String METHOD_GET_BANNER = "GetRadioBannerList";
        public static final String METHOD_GET_LONG_AUDIO_LIST = "GetLongAudioList";
        public static final String METHOD_GET_RADIO_LIST = "GetRadiolist";
        public static final String MODULE = "pf.radiosvr";
    }

    public interface MrcReportDataServer {
        public static final String GET_REPORT_SONG = "get_report_song";
        public static final String MODULE = "Report.ReportDataServer";
    }

    public interface MrcScanImg {
        public static final String GET_CUSTOM_INFO = "get_custom_info";
        public static final String MODULE = "scan_image.CustomInfoServer";
    }

    public interface MusicBoss {
        public static final String METHOD = "get_ad_info";
        public static final String MODULE = "MusicBoss.MusicBossAd";
    }

    public interface MusicDiskReadServer {
        public static final String GET_MATCH_AUDIO = "GetMatchAudio";
        public static final String MODULE = "WeiyunMusic.WeiyunMusicReadServer";
    }

    public interface MusicDiskWriteServer {
        public static final String DELETE_AUDIO = "DeleteAudio";
        public static final String JUDGE_UPLOAD = "JudgeUpload";
        public static final String MODULE = "WeiyunMusic.WeiyunMusicWriteServer";
        public static final String UPLOAD_AUDIO = "UploadAudio";
    }

    public interface MusicHallFeedBackOptionServer {
        public static final String METHOD = "get_feedback_option";
        public static final String MODULE = "mhall.FeedBackOptionServer";
    }

    public interface MusicHallFeedBackServer {
        public static final String METHOD = "feedback";
        public static final String MODULE = "mhall.MHallFeedBackServer";
    }

    public interface MusicHallRecommSvr {
        public static final String GET_GROUP_RECOMM = "get_infinite_feed";
        public static final String MODULE = "mhall.MHallFeedServer";
    }

    public interface MusicHallVip {
        public static final String GET_GROUP_LIST = "get_group_list";
        public static final String MODULE = "MusichallVip.MusichallVipService";
    }

    public interface MusicMessageCenterGetConfig {
        public static final String CONFIG_TYPE = "config_type";
        public static final String METHOD = "GetConfig";
        public static final String MODULE = "MusicMessageCenter.MusicMessageCenterReadServer";
    }

    public interface MusicMessageCenterSetConfig {
        public static final String CONFIG_TYPE = "config_type";
        public static final String CONFIG_VALUE = "config_value";
        public static final String METHOD = "SetConfig";
        public static final String MODULE = "MusicMessageCenter.MusicMessageCenterWriteServer";
    }

    public interface MyFollowingRecommendServer {
        public static final String METHOD = "get_recommend_following";
        public static final String METHOD_SINGER = "get_recommend_singer";
        public static final String MODULE = "follow.MyFollowingCelebrityServer";
    }

    public interface MyFollowingServer {
        public static final String ENTRANCE_METHOD = "get_portal_message";
        public static final String MODULE = "follow.MyFollowingPortalServer";
        public static final String SERECT_UIN = "secret_uin";
    }

    public interface MyFollowingTimelineServer {
        public static final String GET_NEWMUSIC = "get_music_feed";
        public static final String GET_TIMELINE = "get_moment_feed";
        public static final String MODULE = "follow.MyFollowingFeedServer";
        public static final String SERECT_UIN = "secret_uin";
    }

    public interface MyMusicRecommend {
        public static final String METHOD_FOLDER = "get_mine_gedan";
        public static final String METHOD_SONG = "get_mine_track";
        public static final String MODULE = "music.mb_mine_recom_svr";
    }

    public interface MyMusicRunningSetting {
        public static final String EXTEND = "extend";
        public static final String METHOD_CLEAR_RED_DOT = "clear_red_dot";
        public static final String METHOD_GET_RED_DOT = "get_red_dot_status";
        public static final String METHOD_GET_TITLE = "get_entry_configure";
        public static final String MODULE = "RunRadio.RunRadioServerServer";
    }

    public interface NameCertified {
        public static final String METHOD = "get_cert_info";
        public static final String MODULE = "Cert.CertificationServer";
    }

    public interface NewSong {
        public static final String GET_NEW_SONGS = "get_new_song_info";
        public static final String MODULE = "newsong.NewSongServer";
        public static final String PARAM_TYPE = "type";
    }

    public interface OpenIDAuth {
        public static final String METHOD_AUTH = "Auth";
        public static final String METHOD_CHECK_CODE = "CheckAuthCode";
        public static final String METHOD_CHECK_TOKEN = "CheckToken";
        public static final String METHOD_QRCODE_AUTH = "QrcodeAuth";
        public static final String METHOD_VALID_APP = "ValidApp";
        public static final String MODULE = "OpenId.OpenIdServer";
    }

    public interface PayAlert {
        public static final String MODULE = "Musichall.pf_uniform_config_svr";
        public static final String PAY_ALERT = "get_pay_alert";
    }

    public interface PlayerRecommendServer {
        public static final String METHOD_ADVERTISING = "ProcessRequest";
        public static final String METHOD_FRIENDS_LIKE = "get_favourite_song";
        public static final String METHOD_HAS_SIMILAR_SONG = "hasSimSong";
        public static final String METHOD_OTHER_VERSION = "get_song_versions";
        public static final String METHOD_RELATED_ARTICLE = "get_song_magzine";
        public static final String METHOD_RELATED_LIST = "get_related_gedan";
        public static final String METHOD_RELATED_MV = "GetSongRelatedMv";
        public static final String METHOD_SIMILAR_SONG = "get_simsongs";
        public static final String METHOD_SONG_DETAIL = "get_simple_song_detail";
        public static final String METHOD_VIEW_ORDER = "get_recommed_modules";
        public static final String MODULE = "music.pf_song_detail_svr";
        public static final String MODULE_ADVERTISING = "Advert.SdkAdvertServer";
        public static final String MODULE_FRIENDS_LIKE = "friend_listen.FriendListenInfoRecomm";
        public static final String MODULE_RELATED_ARTICLE = "magzine.MagzineRelationServer";
        public static final String MODULE_RELATED_LIST = "music.mb_gedan_recommend_svr";
        public static final String MODULE_RELATED_MV = "MvService.MvInfoProServer";
        public static final String MODULE_SIMILAR_SONG = "rcmusic.similarSongRadioServer";
    }

    public interface PostMomentServer {
        public static final String METHOD = "submit_moment";
        public static final String MODULE = "magzine.MomentWriteServer";
    }

    public interface ProvacyLock {
        public static final String METHOD_GET = "get_lock_status";
        public static final String METHOD_GET_ALL = "get_all_lock_status";
        public static final String METHOD_SET = "set_lock_status";
        public static final String MODULE = "Asset.PrivacyLockServer";
    }

    public interface RemindTips {
        public static final String METHOD_REMIND_TIPS = "fcg_mobile_vip_remind_tips";
        public static final String MODULE = "RemindCenter.RemindView";
    }

    public interface RunningCategoryServer {
        public static final String BPM = "bpm";
        public static final String METHOD = "get_classify_info";
        public static final String MODULE = "RunRadio.RunRadioServerServer";
        public static final String STUB = "stub";
    }

    public interface RunningFolderServer {
        public static final String BPM = "bpm";
        public static final String CATEGORY_ID = "classifyid";
        public static final String LAST_FOLDER_ID = "lastdissid";
        public static final String METHOD = "get_disslist_by_classifyid";
        public static final String MODULE = "RunRadio.RunRadioServerServer";
        public static final String PAGE_SIZE = "page_size";
        public static final String RUN_ID_LIST = "idlist";
        public static final String START_PAGE = "start_page";
    }

    public interface ScanImgSvr {
        public static final String GET_AR_PRELOAD_FEATURE = "get_scan_preload_feature";
        public static final String GET_SCAN_CONF = "get_scan_activity_conf";
        public static final String MODULE = "scan_image.CustomInfoServer";
    }

    public interface SingerList {
        public static final String MODULE = "musichall.singerlistserver";
        public static final String SINGER_LIST = "GetSingerList";
    }

    public interface SingerMVServer {
        public static final String METHOD_MV_FILTER = "GetSingerMvTag";
        public static final String METHOD_MV_LIST = "GetSingerMvList";
        public static final String METHOD_MV_SIMILAR = "GetSingerSimMv";
        public static final String MODULE = "MvService.MvInfoProServer";
    }

    public interface SongOrderServer {
        public static final String METHOD = "GetH5EntryConf";
        public static final String MODULE = "SongOrder.SongOrderConfServer";
    }

    public interface SrfCdnDispatch {
        public static final String CMD = "cmd";
        public static final String METHOD = "GetCdnDispatch";
        public static final String MODULE = "CDN.SrfCdnDispatchServer";
        public static final String PARAM_GUID = "guid";
        public static final String PARAM_UID = "uid";
    }

    public interface SurprisingScenesServer {
        public static final String METHOD = "get_track_egg";
        public static final String MODULE = "VipMusic.TrackWhite";
    }

    public interface TabABTest {
        public static final String METHOD = "get_tab_abtest";
        public static final String MODULE = "recommend.TabABTestServer";
    }

    public interface TaskMallRead {
        public static final String METHOD_GET_TASK_ENTRY_CONFIGURE = "get_task_entry_configure";
        public static final String MODULE = "integral.task_mall_read";
    }

    public interface TaskMallWrite {
        public static final String METHOD_CLEAR_RED_DOT_STATUS = "clear_red_dot_status";
        public static final String MODULE = "integral.task_mall_write";
    }

    public interface Theme {
        public static final String COUNT_USE_METHOD = "counte_use";
        public static final String GET_INTR_INFO = "get_intr_info";
        public static final String METHOD = "get_subject_info";
        public static final String MODULE = "Personal.PersonalCenterV2";
    }

    public interface TimelineBlack {
        public static final String ALTERNATIVE_UIN = "alternative_uin";
        public static final String CMD = "cmd";
        public static final String METHOD = "get_recommend_video";
        public static final String MODULE = "magzine.MagzineRelationServer";
        public static final String MOID = "moid";
        public static final String MOID_TYPE = "moid_type";
        public static final String REC_BIZ = "recommend_biz";
        public static final String REC_REASON = "v_rec_reason";
        public static final String SELF_OPT = "self_opt";
        public static final String SIN = "sin";
        public static final String SIZE = "size";
        public static final String SOURCE = "source";
        public static final String V_EXPOSE = "v_expose";
    }

    public interface TimelineReportServer {
        public static final String CMD = "cmd";
        public static final String ITEMS = "v_item";
        public static final String METHOD = "report";
        public static final String MODULE = "magzine.MomentReportServer";
    }

    public interface TrackInfo {
        public static final String METHOD_GET_TRACK_INFO = "GetTrackInfo";
        public static final String MODULE = "track_info.UniformRuleCtrlServer";
    }

    public interface TrackRadioSvr {
        public static final String GET_RADIO_TRACK = "get_radio_track";
        public static final String MODULE = "mb_track_radio_svr";
    }

    public interface UniteConfigRead {
        public static final String GET_UNIT_CONFIG = "GetUniteConfig";
        public static final String MODULE = "UniteConfig.UniteConfigRead";
    }

    public interface UserBuyList {
        public static final String METHOD = "QryUsrBuyCount";
        public static final String MODULE = "mall.mall_asset_mgr_svr";
    }

    public interface VideoInfoBatch {
        public static final String METHOD = "get_video_info_batch";
        public static final String MODULE = "video.VideoDataServer";
        public static final String REQUIRED = "required";
        public static final String VID_LIST = "vidlist";
    }

    public interface VideoListBySong {
        public static final String METHOD = "get_videolist_by_songid";
        public static final String MODULE = "video.VideoLogicServer";
        public static final String SONG_ID = "song_id";
        public static final String SONG_TYPE = "song_type";
    }

    public interface VideoRecommend {
        public static final String METHOD = "rec_video_byvid";
        public static final String MODULE = "video.VideoLogicServer";
        public static final String REQUIRED = "required";
        public static final String SUPPORT = "support";
        public static final String VID = "vid";
    }

    public interface VideoTopicLabelServer {
        public static final String METHOD_FEEDS = "get_feedflow_content";
        public static final String METHOD_HEADER = "get_feedflow_basic";
        public static final String MODULE = "magzine.FeedflowReadServer";
    }

    public interface VipCenter {
        public static final String METHOD = "get_vip_reddot";
        public static final String MODULE = "VipCenter.MyVipRed";
    }

    public interface VipLogin {
        public static final String METHOD = "vip_login_base";
        public static final String METHOD_ENTRY = "fcg_login_vip_entry";
        public static final String METHOD_VIP_LOGIN = "fcg_vip_login";
        public static final String MODULE = "VipLogin.VipLoginInter";
    }

    public interface VipOrderBaseServer {
        public static final String METHOD = "GetBillNo";
        public static final String MODULE = "VipOrder.VipOrderBaseServer";
        public static final String SERVICE_NAME = "service_name";
    }

    public interface WeeklyPlaylistServer {
        public static final String METHOD = "get_weekly_playlist";
        public static final String MODULE = "playlist.WeeklyPlaylistServer";
    }

    public interface WeishiMusic {
        public static final String METHOD = "GetPageUrl";
        public static final String MODULE = "Ws.WsMusicApi";
    }

    public interface NewComment{
        public static final String METHOD="GetNewCommentList";
        public static final String MODULE = "music.globalComment.CommentReadServer";
    }
}