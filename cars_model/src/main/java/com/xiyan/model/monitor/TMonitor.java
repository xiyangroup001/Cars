package com.xiyan.model.monitor;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @antuor binwang
 * @date 2018/2/2  13:15
 */
public class TMonitor {
    private static final ConcurrentMap<String, Boolean> qMonitorKeyMap = new ConcurrentHashMap();
    private static final String QMONITOR_KEY_PREFIX = "QMonitorItem";
    private static final String INNER_COUNT_SUFFIX = "_Counts";
    private static final String INNER_TIME_SUFFIX = "_Times";
    private static final String VALUE_SUFFIX = "_Value";
    private static final String TIME_SUFFIX = "_Time";
    private static final String COUNT_SUFFIX = "_Count";
    //    private static final AbstractTujiaMutiMonitor tujiaMutiLongMonitor = MutiLongMonitor.buildWithPrefix("QMonitorItem", "QMonitor监控", true);
    private static final int COMPUTE_PERIOD_TIME_SECONDS = 2;
    private static long lastRunTime = 0L;
    //    private static final AtomicLongCounter JVM_THREAD_COUNT = TujiaMonitor.createAtomicLongCounter("JVM_Thread_Count", "线程数");
    private static ConcurrentMap<String, TMonitor.MonitorItem> systemItems = new ConcurrentHashMap();
    private static final ScheduledExecutorService TMonitorScheduler = Executors.newScheduledThreadPool(1, new ThreadFactory() {
        public Thread newThread(Runnable r) {
            return new Thread(r, "QMonitor-monitor-task");
        }
    });
    private static ThreadLocal<Long> lastSMonitorStartTime = new ThreadLocal<Long>() {
        protected Long initialValue() {
//            return SystemTimer.currentTimeMillis();
            return 1l;
        }
    };
    private static final String TOMCAT_PREFIX = "TOMCAT_";
    private static final String JVM_PREFIX = "JVM_";

    private static String makeName(String name) {
        return name.replaceAll(" ", "_");
    }

    private static void addComputedCounter(String name, String desc, long count, long time, boolean needTime) {
//        TMonitor.MonitorItem item = (TMonitor.MonitorItem)systemItems.get(name);
//        boolean justCreated = false;
//        if (item == null) {
//            item = new TMonitor.MonitorItem((TMonitor.MonitorItem)null);
//            item.add(count, time);
//            systemItems.put(name, item);
//            justCreated = true;
//        }
//
//        AtomicLongCounter counter = fetchLongMonitorByName(name + "_Count", desc);
//        counter.set(count - item.count);
//        if (needTime) {
//            AtomicLongCounter timeCounter = fetchLongMonitorByName(name + "_Time", desc);
//            if (count - item.count > 0L) {
//                timeCounter.set((time - item.time) / (count - item.count));
//            } else {
//                timeCounter.set(0L);
//            }
//        }
//
//        if (!justCreated) {
//            item = new TMonitor.MonitorItem((TMonitor.MonitorItem)null);
//            item.add(count, time);
//            systemItems.put(name, item);
//        }

    }

    private static void runTask() {
//        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
//        JVM_THREAD_COUNT.set(threadBean.getThreadCount());
//        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
//
//        String name;
//        long count;
//        long time;
//        for(Iterator var4 = gcBeans.iterator(); var4.hasNext(); addComputedCounter(name, "JVM", count, time, true)) {
//            GarbageCollectorMXBean bean = (GarbageCollectorMXBean)var4.next();
//            name = makeName("JVM_" + bean.getName());
//            count = bean.getCollectionCount();
//            time = bean.getCollectionTime();
//            TMonitor.MonitorItem item = (TMonitor.MonitorItem)systemItems.get(name);
//            if (item == null) {
//                item = new TMonitor.MonitorItem((TMonitor.MonitorItem)null);
//                item.add(count, time);
//                systemItems.put(name, item);
//            }
//        }
//
//        List<TomcatInformations> list = TomcatInformations.buildTomcatInformationsList();
//        Iterator var23 = list.iterator();
//
//        while(var23.hasNext()) {
//            TomcatInformations tomcatInfo = (TomcatInformations)var23.next();
//            String tomcatThreadPoolName = StringUtils.trimToEmpty(tomcatInfo.getName()).replaceAll("\"", "");
//            if (!StringUtils.isEmpty(tomcatThreadPoolName)) {
//                int maxThreads = tomcatInfo.getMaxThreads();
//                int currentThreadCount = tomcatInfo.getCurrentThreadCount();
//                int currentThreadsBusy = tomcatInfo.getCurrentThreadsBusy();
//                long bytesRecv = tomcatInfo.getBytesReceived();
//                long bytesSent = tomcatInfo.getBytesSent();
//                int requestCount = tomcatInfo.getRequestCount();
//                int errorCount = tomcatInfo.getErrorCount();
//                long processingTime = tomcatInfo.getProcessingTime();
//                AtomicLongCounter maxThreadCounter = fetchLongMonitorByName(makeName("TOMCAT_" + tomcatThreadPoolName + "_maxThread" + "_Value"), "TOMCAT");
//                maxThreadCounter.set(maxThreads);
//                AtomicLongCounter currentThreadCounter = fetchLongMonitorByName(makeName("TOMCAT_" + tomcatThreadPoolName + "_currentThread" + "_Value"), "TOMCAT");
//                currentThreadCounter.set(currentThreadCount);
//                AtomicLongCounter currentThreadBusyCounter = fetchLongMonitorByName(makeName("TOMCAT_" + tomcatThreadPoolName + "_currentThreadsBusy" + "_Value"), "TOMCAT");
//                currentThreadBusyCounter.set(currentThreadsBusy);
//                addComputedCounter(makeName("TOMCAT_" + tomcatThreadPoolName + "_bytesReceived"), "TOMCAT", bytesRecv, 0L, false);
//                addComputedCounter(makeName("TOMCAT_" + tomcatThreadPoolName + "_bytesSent"), "TOMCAT", bytesSent, 0L, false);
//                addComputedCounter(makeName("TOMCAT_" + tomcatThreadPoolName + "_request"), "TOMCAT", (long)requestCount, processingTime, true);
//                addComputedCounter(makeName("TOMCAT_" + tomcatThreadPoolName + "_error"), "TOMCAT", (long)errorCount, 0L, false);
//            }
//        }

    }

//    private static AtomicLongCounter fetchLongMonitorByName(String name, String description) {
//        AtomicLongCounter counter = (AtomicLongCounter)TujiaMonitor.getMonitor(name);
//        if (counter == null) {
//            if (qMonitorKeyMap.putIfAbsent(name, Boolean.TRUE) == null) {
//                counter = TujiaMonitor.createAtomicLongCounter(name, description);
//            } else {
//                counter = (AtomicLongCounter)TujiaMonitor.getMonitor(name);
//            }
//        }
//
//        return counter;
//    }

    private TMonitor() {
    }

    public static void recordTimeStart() {
        //    lastSMonitorStartTime.set(SystemTimer.currentTimeMillis());
    }

    public static void recordTimeEnd(String name) {
        //    long now = SystemTimer.currentTimeMillis();
        //   recordMany(name, 1L, now - ((Long)lastSMonitorStartTime.get()).longValue());
    }

    public static void recordOne(String name, long time) {
        recordMany(makeName(name), 1L, time);
    }

    public static void recordOne(String name) {
        incrementByCount(makeName(name), 1L);
    }

    public static void decrRecord(String name) {
        incrementByCount(makeName(name), -1L);
    }

    public static void incrRecord(String name, long count) {
        incrementByCount(makeName(name), count);
    }

    public static void incrRecord(String name, long count, long time) {
        recordMany(makeName(name), count, time);
    }

    public static void generateRate(String name, String desc, String denominatorKey, String numeratorKey) {
        registerRateCalculator(makeName(name), desc, makeName(denominatorKey), makeName(numeratorKey), true);
    }

    public static void generateSuccessRate(String name, String desc, String denominatorKey, String numeratorKey) {
        registerRateCalculator(makeName(name) + "_SuccessRate", desc, makeName(denominatorKey), makeName(numeratorKey), true);
    }

    public static void generateFaildRate(String name, String desc, String denominatorKey, String numeratorKey) {
        registerRateCalculator(makeName(name) + "_FaildRate", desc, makeName(denominatorKey), makeName(numeratorKey), false);
    }

    private static String makeKey(String prefix, String key, String suffix) {
        return prefix + "." + key + suffix;
    }

    private static void incrementByCount(final String name, long count) {
//        tujiaMutiLongMonitor.increment(name + "_Counts", (int)count);
//        if (qMonitorKeyMap.putIfAbsent(name, Boolean.TRUE) == null) {
//            TujiaMonitor.addComputerMonitor(name + "_Count", "计数器", new ComputerMonitor() {
//                public Number getValue() {
//                    return this.getLast1Minutes(TMonitor.makeKey("QMonitorItem", name, "_Counts"));
//                }
//            });
//        }

    }

    private static void registerRateCalculator(String name, String desc, String denominatorKey, String numeratorKey, boolean isSucessRate) {
//        TujiaMonitor.addComputerMonitor(name + "_Value", desc, new RateComputerIncrementMonitor(makeKey("QMonitorItem", denominatorKey, "_Counts"), makeKey("QMonitorItem", numeratorKey, "_Counts"), 1, isSucessRate));
    }

    private static void recordMany(final String name, long count, long time) {
//        tujiaMutiLongMonitor.increment(name + "_Counts", (int)count);
//        tujiaMutiLongMonitor.increment(name + "_Times", (int)time);
//        if (qMonitorKeyMap.putIfAbsent(name, Boolean.TRUE) == null) {
//            TujiaMonitor.addComputerMonitor(name + "_Time", "平均耗时", new ComputerMonitor() {
//                public Number getValue() {
//                    long count = this.getLast1Minutes(TMonitor.makeKey("QMonitorItem", name, "_Counts")).longValue();
//                    long time = this.getLast1Minutes(TMonitor.makeKey("QMonitorItem", name, "_Times")).longValue();
//                    return (Number)(count > 0L ? time / count : Integer.valueOf(0));
//                }
//            });
//            TujiaMonitor.addComputerMonitor(name + "_Count", "计数器", new ComputerMonitor() {
//                public Number getValue() {
//                    return this.getLast1Minutes(TMonitor.makeKey("QMonitorItem", name, "_Counts"));
//                }
//            });
//        }

    }

    public static void recordSize(String name, long size) {
//        AtomicLongCounter counter = fetchLongMonitorByName(name + "_Value", "绝对值监控");
//        counter.set((int)size);
    }

    public static void recordValue(String name, long count) {
//        AtomicLongCounter counter = fetchLongMonitorByName(name + "_Value", "绝对值监控");
//        counter.increment((int)count);
    }

    public static Map<String, Number> getValues() {
//        Map<String, Number> monitorData = TujiaMonitor.getMonitorData("*");
//        Iterator iterator = monitorData.entrySet().iterator();
//
//        while(true) {
//            while(iterator.hasNext()) {
//                Map.Entry<String, Number> entry = (Map.Entry)iterator.next();
//                String key = StringUtils.trimToNull((String)entry.getKey());
//                if (key != null && !key.isEmpty()) {
//                    if (!key.endsWith("_Value") && !key.endsWith("_Count") && !key.endsWith("_Time")) {
//                        iterator.remove();
//                    }
//                } else {
//                    iterator.remove();
//                }
//            }
//
//            return Collections.unmodifiableMap(monitorData);
//        }
        return null;
    }

    static {
//        TMonitorScheduler.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                try {
//                    long now = SystemTimer.currentTimeMillis();
//                    if (now - TMonitor.lastRunTime < TimeUnit.MILLISECONDS.convert(50L, TimeUnit.SECONDS)) {
//                        return;
//                    }
//
//                    long seconds = DateUtils.getFragmentInSeconds(new Date(now), 12);
//                    if (seconds > 10L) {
//                        return;
//                    }
//
//                    TMonitor.lastRunTime = now;
//                    TMonitor.runTask();
//                } catch (Exception var5) {
//                    var5.printStackTrace();
//                }
//
//            }
//        }, 0L, 2L, TimeUnit.SECONDS);
    }

    private static class MonitorItem {
        private long count;
        private long time;

        public synchronized void add(long count, long time) {
            this.count += count;
            this.time += time;
        }

        private MonitorItem() {
        }

        MonitorItem(TMonitor.MonitorItem monitoritem) {
            this();
        }
    }
}

