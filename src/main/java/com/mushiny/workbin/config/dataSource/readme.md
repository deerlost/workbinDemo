# instock2.0自动匹配多个数据源
<br><br>
##一.功能描述
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目中可能需要从其它非主要数据库中读取和管理数据，为了能够灵活地指定具体的
数据库，本配置基于注解和AOP的方法实现多数据源自动切换。在使用过程中，只需
添加一个注解就可以使用，简单方便。
##二.配置方式
<ol>
<li>
	不启用多个数据源
</li>
	<pre>
		<code>
			 //第一种配置方法默认配置不用特殊更改
			 spring:
				 datasource:
				    name: wms
				    url: mysql-url
				    username: inossem
				    password: '!@#QWE123qwe'
				    driver-class-name: com.mysql.jdbc.Driver
		</code>
	</pre>
<li>
	启用多个数据源
	<pre>
		<code>
			 //第一种配置方法
			 spring:
				 datasource:
			        names: primary,secondary
				    url: mysql-url
				    username: ~
				    password: ~
				    driver-class-name: com.mysql.jdbc.Driver
				    primary:
				      url: mysql-url
				      username: inossem
				      password: '!@#QWE123qwe'
				      driver-class-name: com.mysql.jdbc.Driver
				    secondary:
				      url: mysql-url
				      username: ~
				      password: ~
				      driver-class-name: com.mysql.jdbc.Driver
			//第二种配置方法
			spring:
				 datasource:
				    defaultname: primary
				    names: primary,secondary
				    primary:
				      url: mysql-url
				      username: ~
				      password: ~
			          driver-class-name: com.mysql.jdbc.Driver
				    secondary:
				      url: mysql-url
				      username: ~
				      password: ~
			    	  driver-class-name: com.mysql.jdbc.Driver
		</code>
	</pre>
</li>
</ol>
##三.使用方法
<ol>
<li>
	Service切换数据源方法级别
</li>
<pre>
	<code>
		//name 数据源名称
		@Override
	    @TargetDataSource(name="primary")
	    public Object getPrimaryData() {
	        return primaryMapper.selectNewNoDelAndFbNotice();
	    }
	    @Override
	    @TargetDataSource(name="secondary")
	    public Object getSecondaryData() {
	        return primaryMapper.selectNewNoDelAndFbNotice();
	    }
	</code>
</pre>
<li>
	Dao切换数据源方法级别
</li>
<pre>
	<code>
		//name 数据源名称
	    @TargetDataSource(name="primary")
	    int insert(DicNotice record);
		@TargetDataSource(name="secondary")
    	int insertSelective(DicNotice record);
	</code>
</pre>
</li>
</ol>
##四.注意事项
<ol>
<li>
	数据源类型
</li>
项目中默认所有数据源都是springboot2.0自带数据源hikari数据源,如果使用其他数据源需要在配置
文件中添加type参数(例：type: com.zaxxer.hikari.HikariDataSource)
<li>
	关于@TargetDataSource注解
</li>
@TargetDataSource注解可以直接省略不写默认走主数据源
<li>
    事务
</li>
虽然经测试可多个数据源事务,但建议其它数据源只进行查询操作并且每个Serivce,dao方法只调用一个数据源！
</ol>