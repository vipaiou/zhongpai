<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../include/header.jsp" %>
<div class="ui-tab">
<div class="ui-tab-top">
<h2><a href="<%=request.getContextPath()%>/intro">关于众拍网</a></h2>
</div>
<div class="ui-tab-layout">
<ul class="ui-tab-menu">
<li><a href="<%=request.getContextPath()%>/intro" title="服务介绍">服务介绍</a></li>
<li><a href="<%=request.getContextPath()%>/guideline" title="项目规范">项目规范</a></li>
<li><a href="<%=request.getContextPath()%>/faq" title="常见问题">常见问题</a></li>
<li><a href="<%=request.getContextPath()%>/terms_of_service" class="ui-tab-current" title="服务条款">服务条款</a></li>
<li><a href="<%=request.getContextPath()%>/privacy_policy" title="隐私权政策">隐私权政策</a></li>
<li><a href="<%=request.getContextPath()%>/about" title="团队介绍">团队介绍</a></li>
</ul>
</div>
</div>
<div class="content">
<div class="help-end">
<div class="help-end-960">
<p class="help-end-l-t help-end-l-top">接受条款</p>
<p>北京众拍网科技有限公司DemoHour.com (下称"众拍网"或"我们")所提供的服务包含众拍网网站体验和使用、众拍网互联网消息传递服务以及众拍网提供的与众拍网网站有关的任何其他特色功能、内容或应用程序(合称"众拍网服务")。</p>
<p>无论用户是以"访客"(表示用户只是浏览众拍网网站)还是"成员"(表示用户已在众拍网注册并登录)的身份使用众拍网服务，均表示该用户同意遵守本使用协议。</p>
<p>如果用户自愿成为众拍网成员并与其他成员交流(包括通过众拍网网站直接联系或通过众拍网各种服务而连接到的成员)，以及使用众拍网网站及其
各种附加服务，请务必认真阅读本协议并在注册过程中表明同意接受本协议。本协议的内容包含众拍网关于接受众拍网服务和在众拍网网站上发布内容的规
定、用户使用众拍网服务所享有的权利、承担的义务和对使用众拍网服务所受的限制、以及众拍网的隐私条款。</p>
<p>如果用户选择使用某些众拍网服务，可能会收到要求其下载软件或内容的通知，和/或要求用户同意附加条款和条件的通知。除非用户选择使用的众拍网服务相关的附加条款和条件另有规定，附加的条款和条件都应被包含于本协议中。</p>
<p>众拍网有权随时修改本协议文本中的任何条款。一旦众拍网对本协议进行修改,众拍网将会以公告形式发布通知。任何该等修改自发布之日起生效。如
果用户在该等修改发布后继续使用众拍网服务，则表示该用户同意遵守对本协议所作出的该等修改。因此，请用户务必定期查阅本协议，以确保了解所有关于本协
议的最新修改。如果用户不同意众拍网对本协议进行的修改，请用户离开众拍网网站并立即停止使用众拍网服务。同时，用户还应当删除个人档案并注销成员
资格。</p>
<p class="help-end-l-t">遵守法律</p>
<p>当使用众拍网服务时，用户同意遵守中华人民共和国(下称"中国")的相关法律法规，包括但不限于《中华人民共和国宪法》、《中华人民共和国合同
法》、《中华人民共和国电信条例》、《互联网信息服务管理办法》、《互联网电子公告服务管理规定》、《中华人民共和国保守国家秘密法》、《全国人民代表大
会常务委员会关于维护互联网安全的决定》、《中华人民共和国计算机信息系统安全保护条例》、《计算机信息网络国际联网安全保护管理办法》、《中华人民共和
国著作权法》及其实施条例、《互联网著作权行政保护办法》等。用户只有在同意遵守所有相关法律法规和本协议时，才有权使用众拍网服务(无论用户是否有意
访问或使用此服务)。请用户仔细阅读本协议并将其妥善保存。</p>
<p class="help-end-l-t">用户帐号、密码及安全</p>
<p>用户应提供及时、详尽、准确的个人资料，并不断及时更新注册时提供的个人资料，保持其详尽、准确。所有用户输入的资料将引用为注册资料。众拍网不对因用户提交的注册信息不真实或未及时准确变更信息而引起的问题、争议及其后果承担责任。</p>
<p>用户不应将其帐号、密码转让、出借或告知他人，供他人使用。如用户发现帐号遭他人非法使用，应立即通知众拍网。因黑客行为或用户的保管疏忽导致帐号、密码遭他人非法使用的，众拍网不承担任何责任。</p>
<p class="help-end-l-t">隐私权政策</p>
<p>用户提供的注册信息及众拍网保留的用户所有资料将受到中国相关法律法规和众拍网《隐私权政策》的规范。《隐私权政策》构成本协议不可分割的一部分。</p>
<p class="help-end-l-t">上传内容</p>
<p>用户通过任何众拍网提供的服务上传、张贴、发送(通过电子邮件或任何其它方式传送)的文本、文件、图像、照片、视频、声音、音乐、其他创作作品或
任何其他材料(以下简称"内容"，包括用户个人的或个人创作的照片、声音、视频等)，无论系公开还是私下传播，均由用户和内容提供者承担责任，众拍网不
对该等内容的正确性、完整性或品质作出任何保证。用户在使用众拍网服务时，可能会接触到令人不快、不适当或令人厌恶之内容，用户需在接受服务前自行做出
判断。在任何情况下，众拍网均不为任何内容负责(包括但不限于任何内容的错误、遗漏、不准确或不真实)，亦不对通过众拍网服务上传、张贴、发送(通过
电子邮件或任何其它方式传送)的内容衍生的任何损失或损害负责。众拍网在管理过程中发现或接到举报并进行初步调查后，有权依法停止任何前述内容的传播并
采取进一步行动，包括但不限于暂停某些用户使用众拍网的全部或部分服务，保存有关记录，并向有关机关报告。</p>
<p class="help-end-l-t">用户行为</p>
<p>用户在使用众拍网服务时，必须遵守中华人民共和国相关法律法规的规定，用户保证不会利用众拍网服务进行任何违法或不正当的活动，包括但不限于下列行为∶</p>
<ul>
<li>上传、展示、张贴或以其它方式传播含有下列内容之一的信息：</li>
<li>反对宪法及其他法律的基本原则的;</li>
<li>危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的;</li>
<li>损害国家荣誉和利益的;</li>
<li>煽动民族仇恨、民族歧视、破坏民族团结的;</li>
<li>破坏国家宗教政策，宣扬邪教和封建迷信的;</li>
<li>散布谣言，扰乱社会秩序，破坏社会稳定的;</li>
<li>散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的;</li>
<li>侮辱或者诽谤他人，侵害他人合法权利的;</li>
<li>含有虚假、有害、胁迫、侵害他人隐私、骚扰、中伤、粗俗、猥亵、或其它道德上令人反感的内容;</li>
<li>含有中国法律、法规、规章、条例以及任何具有法律效力的规范所限制或禁止的其它内容的;</li>
<li>不得为任何非法目的而使用网络服务系统;</li>
<li>用户同时保证不会利用众拍网服务从事以下活动：</li>
<li>未经允许，进入计算机信息网络或者使用计算机信息网络资源的;</li>
<li>未经允许，对计算机信息网络功能进行删除、修改或者增加的;</li>
<li>未经允许，对进入计算机信息网络中存储、处理或者传输的数据和应用程序进行删除、修改或者增加的;故意制作、传播计算机病毒等破坏性程序的;</li>
<li>其他危害计算机信息网络安全的行为。</li>
</ul>

<p>如用户在使用网络服务时违反任何上述规定，众拍网或经其授权者有权要求该用户改正或直接采取一切必要措施(包括但不限于更改、删除相关内容、暂停或终止相关用户使用众拍网服务)以减轻和消除该用户不当行为造成的影响。</p>
<p>用户不得对众拍网服务的任何部分或全部以及通过众拍网取得的任何形式的信息，进行复制、拷贝、出售、转售或用于任何其它商业目的。</p>
<p>用户须对自己在使用众拍网服务过程中的行为承担法律责任。用户承担法律责任的形式包括但不限于：停止侵害行为，向受到侵害者公开赔礼道歉，恢复受
到侵害这的名誉，对受到侵害者进行赔偿。如果众拍网网站因某用户的非法或不当行为受到行政处罚或承担了任何形式的侵权损害赔偿责任，该用户应向众拍网
进行赔偿(不低于众拍网向第三方赔偿的金额)并通过全国性的媒体向众拍网公开赔礼道歉。</p>
<p class="help-end-l-t">知识产权和其他合法权益(包括但不限于名誉权、商誉等)</p>
<p>众拍网并不对用户发布到众拍网服务中的文本、文件、图像、照片、视频、声音、音乐、其他创作作品或任何其他材料(前文称为"内容")拥有任何所
有权。在用户将内容发布到众拍网服务中后，用户将继续对内容享有权利，并且有权选择恰当的方式使用该等内容。如果用户在众拍网服务中或通过众拍网服
务展示或发表任何内容，即表明该用户就此授予众拍网一个有限的许可以使众拍网能够合法使用、修改、复制、传播和出版此类内容。</p>
<p>用户同意其已就在众拍网服务所发布的内容，授予众拍网可以免费的、永久有效的、不可撤销的、非独家的、可转授权的、在全球范围内对所发布内容进
行使用、复制、修改、改写、改编、发行、翻译、创造衍生性著作的权利，及/或可以将前述部分或全部内容加以传播、表演、展示，及/或可以将前述部分或全部
内容放入任何现在已知和未来开发出的以任何形式、媒体或科技承载的著作当中。</p>
<p>用户声明并保证：用户对其在众拍网服务中或通过众拍网服务发布的内容拥有合法权利;用户在众拍网服务中或通过众拍网服务发布的内容不侵犯任
何人的肖像权、隐私权、著作权、商标权、专利权、及其它合同权利。如因用户在众拍网服务中或通过众拍网服务发布的内容而需向其他任何人支付许可费或其
它费用，全部由该用户承担。</p>
<p>众拍网服务中包含众拍网提供的内容，包含用户和其他众拍网许可方的内容(下称"众拍网的内容")。众拍网的内容受《中华人民共和国著作权
法》、《中华人民共和国商标法》、《中华人民共和国专利法》、《中华人民共和国反不正当竞争法》和其他相关法律法规的保护，众拍网拥有并保持对众拍网
的内容和众拍网服务的所有权利。</p>
<p class="help-end-l-t">国际使用之特别警告</p>
<p>用户已了解国际互联网的无国界性，同意遵守所有关于网上行为、内容的法律法规。用户特别同意遵守有关从中国或用户所在国家或地区输出信息所可能涉及、适用的全部法律法规。</p>
<p class="help-end-l-t">项目筹款</p>
<p>众拍网是一个让用户(即“项目发起人”)通过提供回报向支持者筹集资金的平台。您作为项目发起人，社会大众可以与您订立合同，在众拍网创建筹款
项目。您作为支持者，可以接受项目发起人和您之间的回报和契约，以赞助项目发起人的筹款项目。众拍网并不是支持者和项目发起人中的任何一方。所有交易仅
存在于用户和用户之间。</p>
<p>通过众拍网支持项目，您须同意并遵守以下协议，包括如下条款：</p>
<ul>
<li>支持者同意接受在其承诺支持某项目时提供付款授权信息 。</li>
<li>支持者同意众拍网及其合作伙伴授权或保留收费的权利。</li>
<li>在项目进行中，只要还没有达到100%目标，支持者都可以任意取消支持。一旦该项目达到100%目标后，可以由项目发起人取消支持者的支持，通过众拍网退款给支持者。</li>
<li>回报预期的完成日期并非约定实现的期限，它仅为项目发起人希望实现的日期。</li>
<li>为建立良好的信用和名声，项目发起人会尽力依照预期完成日期实现项目。</li>
<li>对于所有项目，众拍网将提供所有支持者的用户名称和联系方式给于项目发起人。项目成功时，众拍网将额外提供支持者的姓名、联系方式和邮寄地址等信息给于项目发起人。</li>
<li>项目发起人可以在项目成功后直接向支持者要求额外信息。为了顺利获得回报，支持者须同意在合理期限内提供给项目发起人相关信息。</li>
<li>如活动难以进行或无法满足回报需求时，项目发起人可应支持者的请求而退款 。</li>
<li>项目发起人须满足项目成功后支持者的回报需求，或在无法实现的情况下退款。</li>
<li>项目发起人可随时取消或退款给支持者，退款完毕时，无须实现回报要求。</li>
<li>众拍网保留随时以任何理由取消项目的权利。</li>
<li>众拍网有权随时以任何理由拒绝、取消、中断、删除或暂停该项目。众拍网不因该行为承担任何赔偿。众拍网的政策并非评论此类行为的理由。</li>
<li>在项目成功和获得款项之间可能存在延迟。</li>
</ul>
<p>众拍网不承担任何相关回报或使用服务产生的损失或亏损。众拍网无义务介入任何用户之间的纠纷，或用户与其他第三方就服务使用方面产生的纠纷。包
括但不限于货物及服务的交付，其他条款、条件、保证或与网站活动相关联的有关陈述。众拍网不负责监督项目的实现与严格执行。您可授权众拍网、其工作人
员、职员、代理人及对损失索赔权的继任者所有已知或未知、公开或秘密的解决争议的方法和服务。</p>
<p class="help-end-l-t">费用和付款</p>
<p>加入众拍网免费，但是我们对于某些服务是收取费用的。当您使用某项服务时，您将有机会看到您需要支付费用的项目，费用的变化在我们在网站上为您公开后生效。您负责支付使用该服务产生的所有费用和税款。</p>
<p>向支持者筹集的资金通过第三方支付平台支付，众拍网对第三方支付平台的支付性能不承担责任。</p>
<p class="help-end-l-t">赔偿</p>
<p>由于用户通过众拍网服务上传、张贴、发送或传播的内容，或因用户与本服务连线，或因用户违反本使用协议，或因用户侵害他人任何权利而导致任何第三
人向众拍网提出赔偿请求，该用户同意赔偿众拍网及其股东、子公司、关联企业、代理人、品牌共有人或其它合作伙伴相应的赔偿金额(包括众拍网支付的律
师费等)，以使众拍网的利益免受损害。</p>
<p class="help-end-l-t">关于使用及储存的一般措施</p>
<p>用户承认众拍网有权制定关于服务使用的一般措施及限制，包括但不限于众拍网服务将保留用户的电子邮件信息、用户所张贴内容或其它上载内容的最长
保留期间、用户一个帐号可收发信息的最大数量、用户帐号当中可收发的单个信息的大小、众拍网服务器为用户分配的最大磁盘空间，以及一定期间内用户使用点
名时间服务的次数上限(及每次使用时间之上限)。通过众拍网服务存储或传送的任何信息、通讯资料和其它任何内容，如被删除或未予储存，用户同意众拍网
毋须承担任何责任。用户亦同意，超过一年未使用的帐号，众拍网有权关闭。众拍网有权依其自行判断和决定，随时变更相关一般措施及限制。</p>
<p class="help-end-l-t">服务的修改</p>
<p>用户了解并同意，无论通知与否，众拍网有权于任何时间暂时或永久修改或终止部分或全部众拍网服务，对此，众拍网对用户和任何第三人均无需承担
任何责任。用户同意，所有上传、张贴、发送到众拍网的内容，众拍网均无保存义务，用户应自行备份。众拍网不对任何内容丢失以及用户因此而遭受的相关
损失承担责任。</p>
<p class="help-end-l-t">终止服务</p>
<p>用户同意众拍网可单方面判断并决定，如果用户违反本使用协议或用户长时间未能使用其帐号，众拍网可以终止该用户的密码、帐号或某些服务的使用，
并可将该用户在众拍网服务中留存的任何内容加以移除或删除。众拍网亦可基于自身考虑，在通知或未通知之情形下，随时对该用户终止部分或全部服务。用户
了解并同意依本使用协议，无需进行事先通知，众拍网可在发现任何不适宜内容时，立即关闭或删除该用户的帐号及其帐号中所有相关信息及文件，并暂时或永久
禁止该用户继续使用前述文件或帐号。</p>
<p class="help-end-l-t">与广告商进行的交易</p>
<p>用户通过众拍网服务与广告商进行任何形式的通讯或商业往来，或参与促销活动(包括相关商品或服务的付款及交付)，以及达成的其它任何条款、条件、
保证或声明，完全是用户与广告商之间的行为。除有关法律法规明文规定要求众拍网承担责任外，用户因前述任何交易、沟通等而遭受的任何性质的损失或损害，
众拍网均不予负责。</p>
<p class="help-end-l-t">链接</p>
<p>用户了解并同意，对于众拍网服务或第三人提供的其它网站或资源的链接是否可以利用，众拍网不予负责;存在或源于此类网站或资源的任何内容、广
告、产品或其它资料，众拍网亦不保证或负责。因使用或信赖任何此类网站或资源发布的或经由此类网站或资源获得的任何商品、服务、信息，如对用户造成任何
损害，众拍网不负任何直接或间接责任。</p>
<p class="help-end-l-t">禁止商业行为</p>
<p>用户同意不对众拍网服务的任何部分或全部以及用户通过众拍网的服务取得的任何物品、服务、信息等，进行复制、拷贝、出售、转售或用于任何其它商业目的。</p>
<p class="help-end-l-t">众拍网的专属权利</p>
<p>用户了解并同意，众拍网服务及其所使用的相关软件(以下简称"服务软件")含有受到相关知识产权及其它法律保护的专有保密资料。用户同时了解并同
意，经由众拍网服务或广告商向用户呈现的赞助广告或信息所包含之内容，亦可能受到著作权、商标、专利等相关法律的保护。未经众拍网或广告商书面授权，
用户不得修改、出售、传播部分或全部服务内容或软件，或加以制作衍生服务或软件。众拍网仅授予用户个人非专属的使用权，用户不得(也不得允许任何第三
人)复制、修改、创作衍生著作，或通过进行还原工程、反向组译及其它方式破译原代码。用户也不得以转让、许可、设定任何担保或其它方式移转服务和软件的任
何权利。用户同意只能通过由众拍网所提供的界面而非任何其它方式使用众拍网服务。</p>
<p class="help-end-l-t">担保与保证</p>
<p>众拍网使用协议的任何规定均不会免除因众拍网造成用户人身伤害或因故意造成用户财产损失而应承担的任何责任。</p>
<p>用户使用众拍网服务的风险由用户个人承担。众拍网对服务不提供任何明示或默示的担保或保证，包括但不限于商业适售性、特定目的的适用性及未侵害他人权利等的担保或保证。</p>
<p class="help-end-l-t">众拍网亦不保证以下事项：</p>

<ul>
<li>服务将符合用户的要求;</li>
<li>服务将不受干扰、及时提供、安全可靠或不会出错;</li>
<li>使用服务取得的结果正确可靠;</li>
<li>用户经由众拍网服务购买或取得的任何产品、服务、资讯或其它信息将符合用户的期望，且软件中任何错误都将得到更正。</li>
<li>用户应自行决定使用众拍网服务下载或取得任何资料且自负风险，因任何资料的下载而导致的用户电脑系统损坏或数据流失等后果，由用户自行承担。</li>
<li>用户经由众拍网服务获知的任何建议或信息(无论书面或口头形式)，除非使用协议有明确规定，将不构成众拍网对用户的任何保证。</li>
</ul>

<p class="help-end-l-t">责任限制</p>
<p>用户明确了解并同意，基于以下原因而造成的任何损失，众拍网均不承担任何直接、间接、附带、特别、衍生性或惩罚性赔偿责任(即使众拍网事先已被告知用户或第三方可能会产生相关损失)：</p>
<ul>
<li>众拍网服务的使用或无法使用;</li>
<li>通过众拍网服务购买、兑换、交换取得的任何商品、数据、信息、服务、信息，或缔结交易而发生的成本;</li>
<li>用户的传输或数据遭到未获授权的存取或变造;</li>
<li>任何第三方在众拍网服务中所作的声明或行为;</li>
<li>与众拍网服务相关的其它事宜，但本使用协议有明确规定的除外。</li>
</ul>
<p class="help-end-l-t">一般性条款</p>
<p>本使用协议构成用户与众拍网之间的正式协议，并用于规范用户的使用行为。在用户使用众拍网服务、使用第三方提供的内容或软件时，在遵守本协议的基础上，亦应遵守与该等服务、内容、软件有关附加条款及条件。</p>
<p>本使用协以及用户与众拍网之间的关系，均受到中华人民共和国法律管辖。</p>
<p>用户与众拍网就服务本身、本使用协议或其它有关事项发生的争议，应通过友好协商解决。协商不成的，应向北京市东城区人民法院提起诉讼。</p>
<p>众拍网未行使或执行本使用协议设定、赋予的任何权利，不构成对该等权利的放弃。</p>
<p>本使用协议中的任何条款因与中华人民共和国法律相抵触而无效，并不影响其它条款的效力。</p>
<p>本使用协议的标题仅供方便阅读而设，如与协议内容存在矛盾，以协议内容为准。</p>
<p class="help-end-l-t">举报</p>
<p>如用户发现任何违反本服务条款的情事，请及时通知众拍网。</p>

</div>
</div>


</div>

<form accept-charset="UTF-8" action="/session" id="new_session" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="4MEd9ulc0V+2tyLPlgl03mLX77UM0sIfuhfR1MeprGk=" type="hidden"></div>
<input id="popup_login_url" name="url" value="<%=request.getContextPath()%>/intro" type="hidden">
<div id="ui_popup_login" class="ui-popup popup-login" style="display:none">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"><span>登录</span></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<div class="pop-up-login">
<div class="pop-up-login-l">
<ul>
<li class="pop-up-login-l-title">你可以通过合作网站的帐号登录</li>
<li class="weibodl">
<a href="#sina" onclick="window.location.href=('/session/connect?provider=sina&amp;url='+$('#popup_login_url').val())" title="新浪微博账号登陆" class="ui-sns-sina" rel="nofollow"></a>
<a href="#tencent" onclick="window.location.href=('/session/connect?provider=tencent&amp;url='+$('#popup_login_url').val())" title="腾讯微博账号登陆" class="ui-sns-qq" rel="nofollow"></a>
<a href="#qzone" onclick="window.location.href=('/session/connect?provider=qzone&amp;url='+$('#popup_login_url').val())" title="QQ空间账号登陆" class="ui-sns-qzone" rel="nofollow"></a>
<a href="#douban" onclick="window.location.href=('/session/connect?provider=douban&amp;url='+$('#popup_login_url').val())" title="豆瓣账号登陆" class="ui-sns-douban" rel="nofollow"></a>
</li>
<li>登录众拍网<br>
如果你真心想做一件事，全世界都会来帮助你<br>
</li>
<li class="new-user-r"><span>新用户？<a href="<%=request.getContextPath()%>/signup?url=http%3A%2F%2Fwww.demohour.com%2Fintro">注册</a></span></li>
</ul>
</div>
<div class="pop-up-login-r">
<ul>
<li><label for="user_email">电子邮件</label></li>
<li><div class="ui-text"><div class="ui-text-right"><input id="user_email" name="email" value="vipaiou@gmail.com" autocomplete="off" placeholder="输入邮箱" class="username-icon" type="text"></div></div></li>
<li><label for="password">用户密码</label></li>
<li><div class="ui-text"><div class="ui-text-right"><input id="user_password" name="password" value="" placeholder="输入密码" class="password-icon" type="password"></div></div><a href="<%=request.getContextPath()%>/forgot?email=vipaiou%40gmail.com" class="lostpassword">忘记密码?</a></li>
<li><div class="ui-checkbox"><label class="ui-checkbox-checked"><input name="auto_login" value="0" type="hidden"><input value="1" name="auto_login" id="auto_login" class="ui-checkbox" checked="checked" type="checkbox">记住我 (下次自动登录)</label></div></li>
<li class="denglu"><div class="ui-button-green ui-button"><span><button type="submit">登　 录</button></span></div><a title="取消登陆" href="#close" class="button-cancel ui-popup-close">取消登录</a></li>
</ul>
</div>
</div>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div> 
</div>
</div>
</form>
<div class="footerwrap">
<div class="footer">
<a href="<%=request.getContextPath()%>/projects/new">发起项目</a>
<a href="<%=request.getContextPath()%>/intro">服务介绍</a>
<a href="<%=request.getContextPath()%>/guideline">项目规范</a>
<a href="<%=request.getContextPath()%>/faq">常见问题</a>
<a href="<%=request.getContextPath()%>/terms_of_service">服务条款</a>
<a href="<%=request.getContextPath()%>/privacy_policy">隐私权政策</a>
<a href="<%=request.getContextPath()%>/about">关于我们</a>
<a href="<%=request.getContextPath()%>/projects/313907">建议反馈</a>
<a href="http://weibo.com/demohour" target="_blank">官方微博</a>
<a href="http://blog.demohour.com/" target="_blank">官方博客</a>
<a href="<%=request.getContextPath()%>/?screen=mobile" class="last">手机版</a>
<p>© 2013北京众拍网科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div style="display: block;" id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/home-ad57123aded690e93b8c0452f3ab9a41.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$("body").on("click","a.ui-popup-login",function(o){$("#ui_popup_login").find("div.ui-popup-content").css("top",$(window).height()/2-200),$("#ui_popup_login").toggle(),$.browser.msie&&$.browser.version<7||("B"==$(o.target).get(0).tagName?$("#popup_login_url").val($(o.target).parent("a").attr("href")):$("#popup_login_url").val($(o.target).attr("href")),o.preventDefault())});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-09-02 21:39:11 +0800'});});
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-23451409-1']);
_gaq.push(['_trackPageview']);
(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
//]]>
</script>
</body></html>